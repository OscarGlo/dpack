import DpackParser.If_Context
import org.antlr.v4.runtime.tree.TerminalNode

fun clean(node: TerminalNode) = node.text.replace(Regex("^\\s*/|\\s*$"), "")

fun str(ctx: DpackParser.VarContext, limit: Boolean = false): String {
    val sel = Sel(ctx.SEL())
    if (limit) sel.limit()
    return "$sel ${ctx.ID().text}"
}

fun str(ctx: DpackParser.EntityDataPathContext) = "${Sel(ctx.SEL())} ${ctx.dataPath().text}"

@Suppress("UNCHECKED_CAST")
class DpackCommandVisitor(private val world: String, private val name: String, private val debug: Boolean = false) :
    DpackBaseVisitor<Any>() {
    private var ifN = -1

    override fun visitProgram(ctx: DpackParser.ProgramContext): Datapack {
        val dp = Datapack(world, name)
        ctx.children?.map { it.accept(this) }?.forEach {
            if (it is Pair<*, *>)
                dp.functions[it.first as String] = it.second as Function
        }
        return dp
    }

    override fun visitFunction(ctx: DpackParser.FunctionContext): Pair<String, Function> {
        // Unpack function params
        val unpack = ctx.ID().drop(1).mapIndexed { i, id ->
            Cmd("scoreboard players operation ${Sel()} $id = ${Sel()} -P$i")
        }
        val cmds = this.visitBlock(ctx.block())
        return ctx.ID(0).text to unpack + cmds
    }

    override fun visitBlock(ctx: DpackParser.BlockContext) = ctx.statement().flatMap(this::visitStatement)

    override fun visitStatement(ctx: DpackParser.StatementContext): List<Cmd> {
        val commands =
            if (ctx.COMMAND() != null)
                listOf(Cmd(clean(ctx.COMMAND())))
            else
                ctx.children[0].accept(this) as List<Cmd>? ?: listOf(Cmd("{UNKNOWN}"))

        return if (debug && ctx.children[0] !is If_Context)
            listOf(Comment(ctx.text.trim())) + commands
        else
            commands
    }

    override fun visitCond(ctx: DpackParser.CondContext): String {
        val neg = ctx.UNLESS() != null

        ctx.boolExpr()?.let { expr ->
            var cond = " score ${str(expr.`var`(), true)} "
            if (expr.op() == null) {
                // Var existence check
                return (if (neg) "if" else "unless") + cond + "matches 0"
            } else {
                // Comparison
                cond = (if (neg) "unless" else "if") + cond
                val num = expr.value().NUM()
                if (num != null) {
                    // Range comparison
                    val op = expr.op().text
                    var n = num.text.toInt()
                    when (op) {
                        "<" -> n--
                        ">" -> n++
                    }
                    var ran = n.toString()
                    when (op[0]) {
                        '<' -> ran = "..$ran"
                        '>' -> ran += ".."
                    }
                    return cond + "matches $ran"
                } else {
                    // Var comparison
                    var op = expr.op().text
                    if (op == "==")
                        op = "="
                    return cond + op + " " + str(expr.value().`var`())
                }
            }
        }

        // Entity existence check
        return (if (neg) "unless" else "if") + " entity ${Sel(ctx.SEL())}"
    }

    private fun ifBlock(block: DpackParser.BlockContext) = this.visitBlock(block).map { it.apply { ifCount++ } }

    override fun visitIf_(ctx: DpackParser.If_Context): List<Cmd> {
        ifN++

        val needAll = ctx.else_if().isNotEmpty() && (ctx.else_if().size > 1 || ctx.else_() != null)

        val ifBlock = run {
            val cmds = mutableListOf(Cmd("tag ${Sel()} add -I$ifN", this.visitCond(ctx.cond())))
            if (needAll)
                cmds += Cmd("tag ${Sel()} add -A$ifN", "if entity ${ETags("$name-C", "-I$ifN")}")
            if (debug)
                cmds.add(0, Comment(ctx.cond().text))
            cmds + ifBlock(ctx.block())
        }

        val elseIfBlocks = ctx.else_if().map { ei ->
            val options = mutableListOf(this.visitCond(ei.cond()))
            if (needAll)
                options.add(0, "unless entity ${ETags("$name-C", "-A$ifN")}")
            val cmds = mutableListOf(
                Cmd("tag ${Sel()} remove -I$ifN"),
                Cmd("tag ${Sel()} add -I$ifN", *options.toTypedArray())
            )
            if (debug)
                cmds.add(0, Comment("else ${ei.cond()}"))
            if (needAll)
                cmds += Cmd("tag ${Sel()} add -A$ifN", "if entity ${ETags("$name-C", "-I$ifN")}")
            cmds + ifBlock(ei.block())
        }

        val elseBlock = if (ctx.else_() != null) {
            val cmds = ifBlock(ctx.else_().block()).toMutableList()
            if (debug) cmds.add(0, Comment("else"))

            if (elseIfBlocks.isEmpty())
                cmds.map { it.apply { simpleElse = true } }
            else {
                val options = mutableListOf<String>()
                if (needAll)
                    options += "unless entity ${ETags("$name-C", "-A$ifN")}"
                listOf(
                    Cmd("tag ${Sel()} remove -I$ifN"),
                    Cmd("tag ${Sel()} add -I$ifN", *options.toTypedArray())
                ) + cmds
            }
        } else emptyList()

        val cmds =
            (ifBlock + elseIfBlocks.flatten() + elseBlock + Cmd("tag ${Sel()} remove -I$ifN")).toMutableList()

        if (needAll)
            cmds += Cmd("tag ${Sel()} remove -A$ifN")

        ifN--
        return cmds
    }

    override fun visitFunCall(ctx: DpackParser.FunCallContext): Any {
        val cmds = emptyList<Cmd>().toMutableList()
        if (ctx.value().isNotEmpty()) {
            cmds += Cmd("""summon armor_stand ~ -64 ~ {Invisible:1,Marker:1,Tags:["$name-S","$name-F"]}""", "at @p")
            // Bind arguments
            cmds += ctx.value().mapIndexed { i, va ->
                if (va.`var`() != null)
                    Cmd("scoreboard players operation ${ETags("$name-F")} -P$i = ${str(va.`var`())}")
                else
                    Cmd("scoreboard players set ${ETags("$name-F")} -P$i ${va.NUM().text}")
            }
        }

        val va = ctx.`var`()
        val call = Cmd("function $name:${va.ID().text}", "store success score ${Sel()} -S")

        if (va.SEL() != null) {
            call.options += "as ${Sel(va.SEL())}"
            call.options += "at @s"
        }

        return cmds + listOf(
            call,
            Cmd(
                """tellraw @a {"color":"red","text":"Error: Function ${va.ID().text} not found"}""",
                "if score ${Sel().limit()} -S matches 0"
            )
        )
    }

    override fun visitAffect(ctx: DpackParser.AffectContext): List<Cmd> {
        val va = str(ctx.`var`())
        ctx.SET()?.let {
            ctx.COMMAND()?.let {
                return listOf(Cmd(clean(it), "store result score $va"))
            }
            ctx.value().`var`()?.let {
                return listOf(Cmd("scoreboard players operation $va = ${str(it)}"))
            }
            return listOf(Cmd("scoreboard players set $va ${ctx.value().text}"))
        }
        ctx.value().`var`()?.let {
            return listOf(Cmd("scoreboard players operation $va ${ctx.opSet().text} ${str(it)}"))
        }
        when (ctx.opSet().text) {
            "+=" -> return listOf(
                Cmd("scoreboard players add $va ${ctx.value().text}")
            )

            "-=" -> return listOf(
                Cmd("scoreboard players remove $va ${ctx.value().text}")
            )
        }
        return listOf(
            Cmd("scoreboard players set ${Sel()} -T ${ctx.value().text}"),
            Cmd("scoreboard players operation $va ${ctx.opSet().text} ${Sel()} -T")
        )
    }

    override fun visitIncdec(ctx: DpackParser.IncdecContext): List<Cmd> {
        val op = if (ctx.INC() != null) "add" else "remove"
        return listOf(Cmd("scoreboard players $op ${str(ctx.`var`())} 1"))
    }

    override fun visitDataSet(ctx: DpackParser.DataSetContext): List<Cmd> {
        val dp = ctx.entityDataPath(0)
        var cmd = ""

        if (ctx.entityDataPath().size > 1) {
            cmd = "data get entity ${str(ctx.entityDataPath(1))}"
        }
        ctx.COMMAND()?.let {
            cmd = clean(it)
        }
        ctx.valString()?.let { v ->
            v.value()?.`var`()?.let {
                cmd = "scoreboard players get ${str(it, true)}"
            } ?: run {
                return listOf(
                    Cmd(
                        "data modify entity ${str(dp)} set value " +
                                (v.STRING() ?: v.value().text)
                    )
                )
            }
        }
        return listOf(Cmd(cmd, "store result entity ${str(dp)} double 1"))
    }

    override fun visitSetData(ctx: DpackParser.SetDataContext): List<Cmd> {
        return listOf(
            Cmd(
                "data get entity ${str(ctx.entityDataPath())}",
                "store result score ${str(ctx.`var`())}"
            )
        )
    }

    override fun visitTellraw(ctx: DpackParser.TellrawContext): List<Cmd> {
        val sel = ctx.SEL()?.let { Sel(it) } ?: Sel("@a")
        val parts = ctx.tellrawPart().map {
            it.STRING()?.text ?: "{\"score\":{\"name\":\"${Sel(it.`var`().SEL())}\",\"objective\":\"${
                it.`var`().ID()
            }\"}}"
        }
        val partsString = if (parts.size == 1) parts[0] else parts.joinToString(",", "[", "]")
        return listOf(Cmd("tellraw $sel $partsString"))
    }
}
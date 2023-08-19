import org.antlr.v4.runtime.tree.TerminalNode

fun TerminalNode.clean() = text.replace(Regex("^\\s*/|\\s*$"), "")

fun DpackParser.VarContext.str(limit: Boolean = false): String {
    val sel = Sel(SEL())
    if (limit) sel.limit()
    return "$sel ${ID().text}"
}
fun DpackParser.EntityDataPathContext.str() = "${Sel(SEL())} ${dataPath().text}"

@Suppress("UNCHECKED_CAST")
class DpackCommandVisitor(private val world: String, private val name: String) : DpackBaseVisitor<Any>() {
    private var ifN = -1

    override fun visitProgram(ctx: DpackParser.ProgramContext): Datapack {
        val dp = Datapack(world, name)
        ctx.children?.map { it.accept(this) }?.forEach {
            if (it is Pair<*, *>)
                dp.functions[it.first as String] = it.second as Function
        }
        return dp
    }

    override fun visitFunction(ctx: DpackParser.FunctionContext): Pair<String, List<Cmd>> {
        // Unpack function params
        val unpack = ctx.ID().drop(1).mapIndexed { i, id ->
            Cmd("scoreboard players operation @e[tag=$name-C] $id = @e[tag=$name-C] -P$i")
        }
        val cmds = ctx.block().accept(this) as List<Cmd>
        return ctx.ID(0).text to unpack + cmds
    }

    override fun visitBlock(ctx: DpackParser.BlockContext): List<Cmd> {
        return ctx.statement().map { it.accept(this) as List<Cmd> }.flatten()
    }

    override fun visitStatement(ctx: DpackParser.StatementContext): List<Cmd> {
        ctx.COMMAND()?.let {
            return listOf(Cmd(it.clean()))
        }

        return ctx.children[0].accept(this) as List<Cmd>? ?: listOf(Cmd("{UNKNOWN}"))
    }

    override fun visitCond(ctx: DpackParser.CondContext): String {
        val neg = ctx.UNLESS() != null

        ctx.boolExpr()?.let { expr ->
            var cond = " score ${expr.`var`().str(true)} "
            if (expr.op() == null) {
                return (if (neg) "if" else "unless") + cond + "matches 0"
            } else {
                cond = (if (neg) "unless" else "if") + cond
                val num = expr.value().NUM()
                if (num != null) {
                    val op = expr.op().text
                    var n = num.text.toInt()
                    when (op) {
                        "<" -> n--
                        ">" -> n++
                    }
                    var ran = n.toString()
                    when {
                        op.startsWith("<") -> ran = "..$ran"
                        op.startsWith(">") -> ran += ".."
                    }
                    return cond + "matches $ran"
                } else {
                    var op = expr.op().text
                    if (op == "==")
                        op = "="
                    return cond + op + " " + expr.value().`var`().str()
                }
            }
        }

        return (if (neg) "unless" else "if") + " entity ${Sel(ctx.SEL())}"
    }

    override fun visitIf_(ctx: DpackParser.If_Context): List<Cmd> {
        fun DpackParser.BlockContext.ifBlock() =
            (this.accept(this@DpackCommandVisitor) as List<Cmd>).map { it.apply { ifCount++ } }
        ifN++

        val needAll = !(ctx.else_if().isEmpty() || (ctx.else_if().size == 1 && ctx.else_() == null))

        val ifBlock = run {
            val l = mutableListOf(Cmd("tag ${Sel()} add -I$ifN", ctx.cond().accept(this) as String))
            if (needAll)
                l += Cmd("tag ${Sel()} add -A$ifN","if entity ${ETags("$name-C", "-I$ifN")}")
            l + ctx.block().ifBlock()
        }

        val elseIfBlocks = ctx.else_if().map { ei ->
            val options = mutableListOf(ei.cond().accept(this) as String)
            if (needAll)
                options.add(0, "unless entity ${ETags("$name-C", "-A$ifN")}")
            val cmds = mutableListOf(
                Cmd("tag ${Sel()} remove -I$ifN"),
                Cmd("tag ${Sel()} add -I$ifN", *options.toTypedArray())
            )
            if (needAll)
                cmds += Cmd("tag ${Sel()} add -A$ifN","if entity ${ETags("$name-C", "-I$ifN")}")
            cmds + ei.block().ifBlock()
        }

        val elseBlock = ctx.else_()?.run {
            if (elseIfBlocks.isEmpty())
                block().ifBlock().map { it.apply { simpleElse = true } }
            else {
                val options = mutableListOf<String>()
                if (needAll)
                    options += "unless entity ${ETags("$name-C", "-A$ifN")}"
                listOf(
                    Cmd("tag ${Sel()} remove -I$ifN"),
                    Cmd("tag ${Sel()} add -I$ifN", *options.toTypedArray())
                ) + block().ifBlock()
            }
        } ?: emptyList()

        var cmds = ifBlock + elseIfBlocks.flatten() + elseBlock +
                listOf(Cmd("tag ${Sel()} remove -I$ifN"))

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
                    Cmd("scoreboard players operation ${ETags("$name-F")} -P$i = ${va.`var`().str()}")
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
            Cmd("""tellraw @a {"color":"red","text":"Error: Function ${va.ID().text} not found"}""",
                "if score ${Sel().limit()} -S matches 0")
        )
    }

    override fun visitAffect(ctx: DpackParser.AffectContext): List<Cmd> {
        val va = ctx.`var`().str()
        ctx.SET()?.let {
            ctx.COMMAND()?.let {
                return listOf(Cmd(it.clean(), "store result score $va"))
            }
            ctx.value().`var`()?.let {
                return listOf(Cmd("scoreboard players operation $va = ${it.str()}"))
            }
            return listOf(Cmd("scoreboard players set $va ${ctx.value().text}"))
        }
        ctx.value().`var`()?.let {
            return listOf(Cmd("scoreboard players operation $va ${ctx.opSet().text} ${it.str()}"))
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
        return listOf(Cmd("scoreboard players $op ${ctx.`var`().str()} 1"))
    }

    override fun visitDataSet(ctx: DpackParser.DataSetContext): List<Cmd> {
        val dp = ctx.entityDataPath(0)
        var cmd = ""

        if (ctx.entityDataPath().size > 1) {
            cmd = "data get entity ${ctx.entityDataPath(1).str()}"
        }
        ctx.COMMAND()?.let {
            cmd = it.clean()
        }
        ctx.valString()?.let { v ->
            v.value()?.`var`()?.let {
                cmd = "scoreboard players get ${it.str(true)}"
            } ?: run {
                return listOf(Cmd(
                    "data modify entity ${dp.str()} set value " +
                    (v.STRING() ?: v.value().text)
                ))
            }
        }
        return listOf(Cmd(cmd, "store result entity ${dp.str()} double 1"))
    }

    override fun visitSetData(ctx: DpackParser.SetDataContext): List<Cmd> {
        return listOf(Cmd(
            "data get entity ${ctx.entityDataPath().str()}",
            "store result score ${ctx.`var`().str()}"
        ))
    }

    override fun visitTellraw(ctx: DpackParser.TellrawContext): List<Cmd> {
        val sel = ctx.SEL()?.let { Sel(it) } ?: Sel("@a")
        val parts = ctx.tellrawPart().map {
            it.STRING()?.text ?:
                "{\"score\":{\"name\":\"${Sel(it.`var`().SEL())}\",\"objective\":\"${it.`var`().ID()}\"}}"
        }
        val partsString = if (parts.size == 1) parts[0] else parts.joinToString(",", "[", "]")
        return listOf(Cmd("tellraw $sel $partsString"))
    }
}
import org.antlr.v4.runtime.tree.TerminalNode

fun clean(node: TerminalNode) = node.text.replace(Regex("^\\s*/|\\s*$"), "")

fun str(ctx: DpackParser.VarContext, limit: Boolean = false): String {
    val sel = Sel(ctx.SEL())
    if (limit) sel.limit()
    return "$sel ${ctx.ID().text}"
}

fun str(ctx: DpackParser.EntityDataPathContext) = "${Sel(ctx.SEL())} ${ctx.dataPath().text}"
import gen.DpackBaseVisitor
import gen.DpackParser

class ScoreboardVisitor : DpackBaseVisitor<Set<String>>() {
    override fun defaultResult() = emptySet<String>()
    override fun aggregateResult(aggregate: Set<String>, nextResult: Set<String>) = aggregate + nextResult

    override fun visitVar(ctx: DpackParser.VarContext?) = ctx?.ID()?.text?.let { setOf(it) } ?: emptySet()

    // Ignore function call vars
    override fun visitFunCall(ctx: DpackParser.FunCallContext) = defaultResult()
}

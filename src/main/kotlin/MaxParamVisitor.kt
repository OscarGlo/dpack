import kotlin.math.max

class MaxParamVisitor : DpackBaseVisitor<Int>() {
    override fun defaultResult() = 0
    override fun aggregateResult(a: Int, b: Int) = max(a, b)

    override fun visitFunction(ctx: DpackParser.FunctionContext) = ctx.ID().size
}

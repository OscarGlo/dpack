import DpackParser.VarContext

class SelId {
    private val text: String

    constructor(sel: Sel, id: String) {
        text = "$sel $id"
    }

    constructor(id: String) : this(Sel(), id)

    constructor(v: VarContext) {
        text = str(v)
    }

    override fun toString() = text
}

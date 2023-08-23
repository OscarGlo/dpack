 import DpackParser.*

open class Cmd(val command: String, vararg options: String) {
    companion object {
        var packName: String = ""
    }

    open class Operation(val target: SelId, val operation: String) {
        fun to(selId: SelId) = Cmd("""scoreboard players operation $target $operation $selId""")
    }

    class Set(target: SelId) : Operation(target, "=") {
        fun to(value: ValueContext) =
            if (value.NUM() != null) Cmd("""scoreboard players set $target ${value.NUM().text}""")
            else to(SelId(value.`var`()))
    }

    val options = options.toMutableList()
    var ifCount = 0
    var simpleElse = false
    var afterReturn = false

    override fun toString(): String {
        if (ifCount > 0)
            options.add(0, (if (simpleElse) "unless" else "if") + " entity ${ETags("$packName-C", "-I${ifCount - 1}")}")
        if (afterReturn)
            options.add(0, "unless entity ${ETags("$packName-C", "-R")}")

        return when {
            options.isEmpty() -> command
            else -> options.joinToString(" ", "execute ", " run ") + command
        }
    }
}

class Comment(text: String) : Cmd("# $text") {
    override fun toString() = command
}
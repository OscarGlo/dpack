class Cmd(val command: String, vararg options: String) {
    companion object {
        var packName: String = ""
    }

    val options = options.toMutableList()
    var ifCount = 0
    var simpleElse = false

    override fun toString(): String {
        if (ifCount > 0)
            options.add(0, (if (simpleElse) "unless" else "if") + " entity ${ETags("$packName-C", "-I${ifCount - 1}")}")

        return when {
            options.isEmpty() -> command
            else -> options.joinToString(" ", "execute ", " run ") + command
        }
    }
}
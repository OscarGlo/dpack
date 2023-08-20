import org.antlr.v4.runtime.tree.TerminalNode

open class Sel(src: String? = null) {
    companion object {
        val regex = Regex("@([parse])(?:\\[(.*)])?")
    }

    private var char = "e"
    private val conditions = mutableMapOf<String, String>()

    init {
        if (src == null) {
            // Current holder
            conditions["tag"] = Cmd.packName + "-C"
        } else {
            val match = regex.find(src)
                ?: error("Invalid selector $src")

            char = match.groupValues[1]

            if (match.groups[2] != null) {
                val conds = match.groups[2]!!.value
                    .split(Regex("\\s*,\\s*"))
                    .associate {
                        it.split("=").zipWithNext().single()
                    }
                conditions.putAll(conds)
            }
        }
    }

    constructor(sel: TerminalNode?) : this(sel?.text)

    fun set(k: String, v: String) = apply { conditions[k] = v }

    fun limit(n: Int = 1) =
        if (char == "e")
            set("limit", n.toString())
        else this

    override fun toString(): String =
        if (conditions.isEmpty()) "@$char"
        else "@$char" + conditions.map { it.key + "=" + it.value }.joinToString(",", "[", "]")
}

class ETags(vararg tags: String) : Sel("@e") {
    init {
        if (tags.size == 1)
            set("tag", tags[0])
        else
            set("nbt", tags.joinToString("\",\"", "{Tags:[\"", "\"]}"))
    }
}
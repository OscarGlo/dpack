import org.antlr.v4.runtime.tree.TerminalNode

open class Sel(src: String? = null) {
    companion object {
        val reg = Regex("@([parse])(?:\\[(.*)])?")
    }

    private var char = "e"
    private val conditions = mutableMapOf<String, String>()

    init {
        when (src) {
            null -> conditions["tag"] = Cmd.packName + "-C"
            else -> {
                val match = reg.find(src)
                    ?: error("Invalid selector $src")

                char = match.groupValues[1]
                match.groups[2]?.value?.split(Regex("\\s*,\\s*"))?.forEach {
                    val (k, v) = it.split("=")
                    conditions[k] = v
                }
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
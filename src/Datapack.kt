import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

const val MC_PATH = "C:\\Users\\Oscar\\AppData\\Roaming\\.minecraft"

typealias Function = List<Cmd>

fun Function.save(path: Path) =
    path.toFile().writeText(this.joinToString("\n", postfix = "\n"))

class Datapack(private val world: String, private val name: String) {
    companion object {
        val defaultScoreboards = setOf("-N", "-S", "-T")
    }

    val functions = mutableMapOf<String, Function>()

    fun save(scoreboards: Set<String>) {
        functions.forEach { (k, v) ->
            if (v.isNotEmpty())
                functions[k] = listOf(Cmd("function $name:-start")) + v + listOf(Cmd("function $name:-return"))
        }

        // Add scoreboard inits in load
        val cmds = functions["load"] ?: emptyList()
        functions["load"] = (defaultScoreboards + scoreboards).map { Cmd("scoreboard objectives add $it dummy") } + cmds

        functions["-start"] = listOf(
            Cmd("tag ${Sel()} remove $name-C"),
            Cmd("scoreboard players add ${ETags("$name-S")} -N 1"),
            Cmd(
                "summon armor_stand ~ -64 ~ {Invisible:1,Marker:1,Tags:[\"$name-S\",\"$name-C\"]}",
                "at @p", "unless entity ${ETags("$name-F")}"
            ),
            Cmd("tag ${ETags("$name-F")} add $name-C"),
            Cmd("scoreboard players set ${Sel()} -N 0"),
            Cmd("tag ${ETags("$name-F")} remove $name-F")
        )

        functions["-return"] = listOf(
            Cmd("kill ${ETags("$name-C")}"),
            Cmd("scoreboard players remove ${ETags("$name-S")} -N 1"),
            Cmd("tag @e[tag=$name-S, scores={-N=0}] add $name-C")
        )

        val worldDir = Paths.get(MC_PATH, "saves", world)
        if (!Files.exists(worldDir))
            error("World $world not found")

        val packDir = Paths.get(worldDir.toString(), "datapacks", name)
        if (!Files.exists(packDir))
            init(packDir, name)

        val funPath = Paths.get(packDir.toString(), "data", name, "functions")
        // Delete old function files
        funPath.toFile().listFiles()?.forEach(File::delete)

        functions.forEach {
            it.value.save(Paths.get(funPath.toString(), it.key + ".mcfunction"))
        }
    }

    private fun init(path: Path, name: String) {
        // Init base path
        path.toFile().mkdirs()

        // Pack Metadata
        Paths.get(path.toString(), "pack.mcmeta")
            .toFile().writeText("{\"pack\": {\"pack_format\": 6,\"description\": \"Pack generated with dpack\"}}")

        // Default tags
        val tags = Paths.get(path.toString(), "data\\minecraft\\tags\\functions").apply {
            toFile().mkdirs()
        }
        Paths.get(tags.toString(), "load.json").toFile().writeText("{\"values\": [\"$name:load\"]}")
        Paths.get(tags.toString(), "tick.json").toFile().writeText("{\"values\": [\"$name:tick\"]}")

        // Functions folder
        Paths.get(path.toString(), "data", name, "functions").toFile().mkdirs()

        println("Empty datapack initialized at $path")
    }
}
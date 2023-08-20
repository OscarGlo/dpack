import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.nio.file.Path

fun main(args: Array<String>) {
    val cli = ArgParser("dpack")

    val debug by cli.option(
        ArgType.Boolean, "debug", "d",
        "Show debug info in compiled function files",
    ).default(false)

    val path by cli.argument(ArgType.String)

    cli.parse(args)

    val file = Path.of(path).toFile()
    if (!file.exists())
        error("$path not found")

    val (world, name) = file.name.toString().split(".")
    Cmd.packName = name

    // Parse file
    val lexer = DpackLexer(CharStreams.fromPath(file.toPath()))
    val parser = DpackParser(CommonTokenStream(lexer))
    val tree = parser.program()

    // Calculate max number of function params and initialize scoreboards
    val maxParams = MaxParamVisitor().visit(tree)
    val scoreboards = (1..maxParams).map { i -> "-P$i" }.toSet() +
            ScoreboardVisitor().visit(tree)

    // Generate and save function files
    val datapack = DpackCommandVisitor(world, name, debug).visit(tree) as Datapack
    datapack.save(scoreboards)
}
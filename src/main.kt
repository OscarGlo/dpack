import gen.DpackLexer
import gen.DpackParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.nio.file.Path

fun main(args: Array<String>) {
    if (args.isEmpty())
        error(".dp file path should be passed to main")

    val path = Path.of(args[0])
    val (world, name) = path.fileName.toString().split(".")

    Cmd.packName = name

    if (!path.toFile().exists())
        error("$path not found")

    val lexer = DpackLexer(CharStreams.fromPath(path))
    val parser = DpackParser(CommonTokenStream(lexer))
    val tree = parser.program()

    val maxParams = MaxParamVisitor().visit(tree)
    val scoreboards = (0 until maxParams).map { i -> "-P$i" }.toSet() +
            ScoreboardVisitor().visit(tree)

    val datapack = DpackCommandVisitor(world, name).visit(tree) as Datapack
    datapack.save(scoreboards)
}
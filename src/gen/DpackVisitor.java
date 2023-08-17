// Generated from D:/Oscar/Programmation/Kotlin/dpack\Dpack.g4 by ANTLR 4.10.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DpackParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DpackVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DpackParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DpackParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(DpackParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DpackParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DpackParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#if_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_(DpackParser.If_Context ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#else_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_if(DpackParser.Else_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#else_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_(DpackParser.Else_Context ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(DpackParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#affect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffect(DpackParser.AffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#opSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpSet(DpackParser.OpSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#dataSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSet(DpackParser.DataSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#setData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetData(DpackParser.SetDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#entityDataPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityDataPath(DpackParser.EntityDataPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#dataPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataPath(DpackParser.DataPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#tellraw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTellraw(DpackParser.TellrawContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#tellrawPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTellrawPart(DpackParser.TellrawPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#funCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCall(DpackParser.FunCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#incdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncdec(DpackParser.IncdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(DpackParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#valString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValString(DpackParser.ValStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DpackParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(DpackParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link DpackParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(DpackParser.OpContext ctx);
}
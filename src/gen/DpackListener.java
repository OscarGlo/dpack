// Generated from D:/Oscar/Programmation/Kotlin/dpack\Dpack.g4 by ANTLR 4.10.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DpackParser}.
 */
public interface DpackListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DpackParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DpackParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DpackParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(DpackParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(DpackParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(DpackParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(DpackParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DpackParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DpackParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#if_}.
	 * @param ctx the parse tree
	 */
	void enterIf_(DpackParser.If_Context ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#if_}.
	 * @param ctx the parse tree
	 */
	void exitIf_(DpackParser.If_Context ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#else_if}.
	 * @param ctx the parse tree
	 */
	void enterElse_if(DpackParser.Else_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#else_if}.
	 * @param ctx the parse tree
	 */
	void exitElse_if(DpackParser.Else_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#else_}.
	 * @param ctx the parse tree
	 */
	void enterElse_(DpackParser.Else_Context ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#else_}.
	 * @param ctx the parse tree
	 */
	void exitElse_(DpackParser.Else_Context ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(DpackParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(DpackParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#affect}.
	 * @param ctx the parse tree
	 */
	void enterAffect(DpackParser.AffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#affect}.
	 * @param ctx the parse tree
	 */
	void exitAffect(DpackParser.AffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#opSet}.
	 * @param ctx the parse tree
	 */
	void enterOpSet(DpackParser.OpSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#opSet}.
	 * @param ctx the parse tree
	 */
	void exitOpSet(DpackParser.OpSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#dataSet}.
	 * @param ctx the parse tree
	 */
	void enterDataSet(DpackParser.DataSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#dataSet}.
	 * @param ctx the parse tree
	 */
	void exitDataSet(DpackParser.DataSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#setData}.
	 * @param ctx the parse tree
	 */
	void enterSetData(DpackParser.SetDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#setData}.
	 * @param ctx the parse tree
	 */
	void exitSetData(DpackParser.SetDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#entityDataPath}.
	 * @param ctx the parse tree
	 */
	void enterEntityDataPath(DpackParser.EntityDataPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#entityDataPath}.
	 * @param ctx the parse tree
	 */
	void exitEntityDataPath(DpackParser.EntityDataPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#dataPath}.
	 * @param ctx the parse tree
	 */
	void enterDataPath(DpackParser.DataPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#dataPath}.
	 * @param ctx the parse tree
	 */
	void exitDataPath(DpackParser.DataPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#tellraw}.
	 * @param ctx the parse tree
	 */
	void enterTellraw(DpackParser.TellrawContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#tellraw}.
	 * @param ctx the parse tree
	 */
	void exitTellraw(DpackParser.TellrawContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#tellrawPart}.
	 * @param ctx the parse tree
	 */
	void enterTellrawPart(DpackParser.TellrawPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#tellrawPart}.
	 * @param ctx the parse tree
	 */
	void exitTellrawPart(DpackParser.TellrawPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#funCall}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(DpackParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#funCall}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(DpackParser.FunCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#incdec}.
	 * @param ctx the parse tree
	 */
	void enterIncdec(DpackParser.IncdecContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#incdec}.
	 * @param ctx the parse tree
	 */
	void exitIncdec(DpackParser.IncdecContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(DpackParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(DpackParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#valString}.
	 * @param ctx the parse tree
	 */
	void enterValString(DpackParser.ValStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#valString}.
	 * @param ctx the parse tree
	 */
	void exitValString(DpackParser.ValStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(DpackParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(DpackParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(DpackParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(DpackParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link DpackParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(DpackParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DpackParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(DpackParser.OpContext ctx);
}
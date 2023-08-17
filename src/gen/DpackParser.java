// Generated from D:/Oscar/Programmation/Kotlin/dpack\Dpack.g4 by ANTLR 4.10.1
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DpackParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, UNLESS=2, ELSE=3, TELLRAW=4, PRINT=5, ENTITY=6, DATA=7, NUM=8, ID=9, 
		STRING=10, SEL=11, COMMAND=12, EQ=13, GTE=14, GT=15, LTE=16, LT=17, INC=18, 
		ADDSET=19, DEC=20, SUBSET=21, MULSET=22, DIVSET=23, MODSET=24, SWAP=25, 
		SET=26, SEP=27, DOT=28, LPAR=29, RPAR=30, LSQ=31, RSQ=32, LCUR=33, RCUR=34, 
		WS=35, LINE_COMMENT=36;
	public static final int
		RULE_program = 0, RULE_function = 1, RULE_block = 2, RULE_statement = 3, 
		RULE_if_ = 4, RULE_else_if = 5, RULE_else_ = 6, RULE_cond = 7, RULE_affect = 8, 
		RULE_opSet = 9, RULE_dataSet = 10, RULE_setData = 11, RULE_entityDataPath = 12, 
		RULE_dataPath = 13, RULE_tellraw = 14, RULE_tellrawPart = 15, RULE_funCall = 16, 
		RULE_incdec = 17, RULE_boolExpr = 18, RULE_valString = 19, RULE_value = 20, 
		RULE_var = 21, RULE_op = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "function", "block", "statement", "if_", "else_if", "else_", 
			"cond", "affect", "opSet", "dataSet", "setData", "entityDataPath", "dataPath", 
			"tellraw", "tellrawPart", "funCall", "incdec", "boolExpr", "valString", 
			"value", "var", "op"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'unless'", "'else'", "'tellraw'", "'print'", "'entity'", 
			"'data'", null, null, null, null, null, "'=='", "'>='", "'>'", "'<='", 
			"'<'", "'++'", "'+='", "'--'", "'-='", "'*='", "'/='", "'%='", "'><'", 
			"'='", "','", "'.'", "'('", "')'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "UNLESS", "ELSE", "TELLRAW", "PRINT", "ENTITY", "DATA", "NUM", 
			"ID", "STRING", "SEL", "COMMAND", "EQ", "GTE", "GT", "LTE", "LT", "INC", 
			"ADDSET", "DEC", "SUBSET", "MULSET", "DIVSET", "MODSET", "SWAP", "SET", 
			"SEP", "DOT", "LPAR", "RPAR", "LSQ", "RSQ", "LCUR", "RCUR", "WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Dpack.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DpackParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(46);
				function();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DpackParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DpackParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(DpackParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(DpackParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> SEP() { return getTokens(DpackParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(DpackParser.SEP, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(ID);
			setState(53);
			match(LPAR);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(54);
				match(ID);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(55);
					match(SEP);
					setState(56);
					match(ID);
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(64);
			match(RPAR);
			setState(65);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCUR() { return getToken(DpackParser.LCUR, 0); }
		public TerminalNode RCUR() { return getToken(DpackParser.RCUR, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(LCUR);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << UNLESS) | (1L << TELLRAW) | (1L << PRINT) | (1L << DATA) | (1L << ID) | (1L << SEL) | (1L << COMMAND))) != 0)) {
				{
				{
				setState(68);
				statement();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(RCUR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public If_Context if_() {
			return getRuleContext(If_Context.class,0);
		}
		public IncdecContext incdec() {
			return getRuleContext(IncdecContext.class,0);
		}
		public AffectContext affect() {
			return getRuleContext(AffectContext.class,0);
		}
		public DataSetContext dataSet() {
			return getRuleContext(DataSetContext.class,0);
		}
		public SetDataContext setData() {
			return getRuleContext(SetDataContext.class,0);
		}
		public TellrawContext tellraw() {
			return getRuleContext(TellrawContext.class,0);
		}
		public FunCallContext funCall() {
			return getRuleContext(FunCallContext.class,0);
		}
		public TerminalNode COMMAND() { return getToken(DpackParser.COMMAND, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				if_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				incdec();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				affect();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				dataSet();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				setData();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				tellraw();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				funCall();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				match(COMMAND);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_Context extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<Else_ifContext> else_if() {
			return getRuleContexts(Else_ifContext.class);
		}
		public Else_ifContext else_if(int i) {
			return getRuleContext(Else_ifContext.class,i);
		}
		public Else_Context else_() {
			return getRuleContext(Else_Context.class,0);
		}
		public If_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterIf_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitIf_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitIf_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_Context if_() throws RecognitionException {
		If_Context _localctx = new If_Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			cond();
			setState(87);
			block();
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
					else_if();
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(94);
				else_();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_ifContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(DpackParser.ELSE, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterElse_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitElse_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitElse_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_ifContext else_if() throws RecognitionException {
		Else_ifContext _localctx = new Else_ifContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_else_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(ELSE);
			setState(98);
			cond();
			setState(99);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_Context extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(DpackParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterElse_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitElse_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitElse_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_Context else_() throws RecognitionException {
		Else_Context _localctx = new Else_Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_else_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(ELSE);
			setState(102);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(DpackParser.IF, 0); }
		public TerminalNode UNLESS() { return getToken(DpackParser.UNLESS, 0); }
		public TerminalNode ENTITY() { return getToken(DpackParser.ENTITY, 0); }
		public TerminalNode SEL() { return getToken(DpackParser.SEL, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==IF || _la==UNLESS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENTITY:
				{
				setState(105);
				match(ENTITY);
				setState(106);
				match(SEL);
				}
				break;
			case ID:
			case SEL:
				{
				setState(107);
				boolExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AffectContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode SET() { return getToken(DpackParser.SET, 0); }
		public OpSetContext opSet() {
			return getRuleContext(OpSetContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode COMMAND() { return getToken(DpackParser.COMMAND, 0); }
		public AffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterAffect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitAffect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitAffect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AffectContext affect() throws RecognitionException {
		AffectContext _localctx = new AffectContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_affect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			var();
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET:
				{
				setState(111);
				match(SET);
				setState(114);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NUM:
				case ID:
				case SEL:
					{
					setState(112);
					value();
					}
					break;
				case COMMAND:
					{
					setState(113);
					match(COMMAND);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case GT:
			case LT:
			case ADDSET:
			case SUBSET:
			case MULSET:
			case DIVSET:
			case MODSET:
			case SWAP:
				{
				setState(116);
				opSet();
				setState(117);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpSetContext extends ParserRuleContext {
		public TerminalNode ADDSET() { return getToken(DpackParser.ADDSET, 0); }
		public TerminalNode SUBSET() { return getToken(DpackParser.SUBSET, 0); }
		public TerminalNode MULSET() { return getToken(DpackParser.MULSET, 0); }
		public TerminalNode DIVSET() { return getToken(DpackParser.DIVSET, 0); }
		public TerminalNode MODSET() { return getToken(DpackParser.MODSET, 0); }
		public TerminalNode LT() { return getToken(DpackParser.LT, 0); }
		public TerminalNode GT() { return getToken(DpackParser.GT, 0); }
		public TerminalNode SWAP() { return getToken(DpackParser.SWAP, 0); }
		public OpSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterOpSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitOpSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitOpSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpSetContext opSet() throws RecognitionException {
		OpSetContext _localctx = new OpSetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_opSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << ADDSET) | (1L << SUBSET) | (1L << MULSET) | (1L << DIVSET) | (1L << MODSET) | (1L << SWAP))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataSetContext extends ParserRuleContext {
		public List<EntityDataPathContext> entityDataPath() {
			return getRuleContexts(EntityDataPathContext.class);
		}
		public EntityDataPathContext entityDataPath(int i) {
			return getRuleContext(EntityDataPathContext.class,i);
		}
		public TerminalNode SET() { return getToken(DpackParser.SET, 0); }
		public ValStringContext valString() {
			return getRuleContext(ValStringContext.class,0);
		}
		public TerminalNode COMMAND() { return getToken(DpackParser.COMMAND, 0); }
		public DataSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterDataSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitDataSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitDataSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSetContext dataSet() throws RecognitionException {
		DataSetContext _localctx = new DataSetContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dataSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			entityDataPath();
			setState(124);
			match(SET);
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
			case ID:
			case STRING:
			case SEL:
				{
				setState(125);
				valString();
				}
				break;
			case DATA:
				{
				setState(126);
				entityDataPath();
				}
				break;
			case COMMAND:
				{
				setState(127);
				match(COMMAND);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetDataContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode SET() { return getToken(DpackParser.SET, 0); }
		public EntityDataPathContext entityDataPath() {
			return getRuleContext(EntityDataPathContext.class,0);
		}
		public SetDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterSetData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitSetData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitSetData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetDataContext setData() throws RecognitionException {
		SetDataContext _localctx = new SetDataContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_setData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			var();
			setState(131);
			match(SET);
			setState(132);
			entityDataPath();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntityDataPathContext extends ParserRuleContext {
		public TerminalNode DATA() { return getToken(DpackParser.DATA, 0); }
		public TerminalNode SEL() { return getToken(DpackParser.SEL, 0); }
		public DataPathContext dataPath() {
			return getRuleContext(DataPathContext.class,0);
		}
		public EntityDataPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityDataPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterEntityDataPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitEntityDataPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitEntityDataPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityDataPathContext entityDataPath() throws RecognitionException {
		EntityDataPathContext _localctx = new EntityDataPathContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_entityDataPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(DATA);
			setState(135);
			match(SEL);
			setState(136);
			dataPath();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataPathContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DpackParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DpackParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(DpackParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(DpackParser.DOT, i);
		}
		public List<TerminalNode> LSQ() { return getTokens(DpackParser.LSQ); }
		public TerminalNode LSQ(int i) {
			return getToken(DpackParser.LSQ, i);
		}
		public List<TerminalNode> NUM() { return getTokens(DpackParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(DpackParser.NUM, i);
		}
		public List<TerminalNode> RSQ() { return getTokens(DpackParser.RSQ); }
		public TerminalNode RSQ(int i) {
			return getToken(DpackParser.RSQ, i);
		}
		public DataPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterDataPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitDataPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitDataPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataPathContext dataPath() throws RecognitionException {
		DataPathContext _localctx = new DataPathContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dataPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ID);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==LSQ) {
				{
				setState(144);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(139);
					match(DOT);
					setState(140);
					match(ID);
					}
					break;
				case LSQ:
					{
					setState(141);
					match(LSQ);
					setState(142);
					match(NUM);
					setState(143);
					match(RSQ);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TellrawContext extends ParserRuleContext {
		public List<TellrawPartContext> tellrawPart() {
			return getRuleContexts(TellrawPartContext.class);
		}
		public TellrawPartContext tellrawPart(int i) {
			return getRuleContext(TellrawPartContext.class,i);
		}
		public TerminalNode PRINT() { return getToken(DpackParser.PRINT, 0); }
		public TerminalNode TELLRAW() { return getToken(DpackParser.TELLRAW, 0); }
		public TerminalNode SEL() { return getToken(DpackParser.SEL, 0); }
		public List<TerminalNode> SEP() { return getTokens(DpackParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(DpackParser.SEP, i);
		}
		public TellrawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tellraw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterTellraw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitTellraw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitTellraw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TellrawContext tellraw() throws RecognitionException {
		TellrawContext _localctx = new TellrawContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tellraw);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !(_la==TELLRAW || _la==PRINT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(150);
				match(SEL);
				}
				break;
			}
			setState(153);
			tellrawPart();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(154);
				match(SEP);
				setState(155);
				tellrawPart();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TellrawPartContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode STRING() { return getToken(DpackParser.STRING, 0); }
		public TellrawPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tellrawPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterTellrawPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitTellrawPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitTellrawPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TellrawPartContext tellrawPart() throws RecognitionException {
		TellrawPartContext _localctx = new TellrawPartContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tellrawPart);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case SEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				var();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunCallContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(DpackParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(DpackParser.RPAR, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(DpackParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(DpackParser.SEP, i);
		}
		public FunCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterFunCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitFunCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitFunCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunCallContext funCall() throws RecognitionException {
		FunCallContext _localctx = new FunCallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_funCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			var();
			setState(166);
			match(LPAR);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << ID) | (1L << SEL))) != 0)) {
				{
				setState(167);
				value();
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(168);
					match(SEP);
					setState(169);
					value();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(177);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncdecContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode INC() { return getToken(DpackParser.INC, 0); }
		public TerminalNode DEC() { return getToken(DpackParser.DEC, 0); }
		public IncdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incdec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterIncdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitIncdec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitIncdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncdecContext incdec() throws RecognitionException {
		IncdecContext _localctx = new IncdecContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_incdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			var();
			setState(180);
			_la = _input.LA(1);
			if ( !(_la==INC || _la==DEC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolExprContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_boolExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			var();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GTE) | (1L << GT) | (1L << LTE) | (1L << LT))) != 0)) {
				{
				setState(183);
				op();
				setState(184);
				value();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValStringContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(DpackParser.STRING, 0); }
		public ValStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterValString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitValString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitValString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValStringContext valString() throws RecognitionException {
		ValStringContext _localctx = new ValStringContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_valString);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
			case ID:
			case SEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				value();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(DpackParser.NUM, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(NUM);
				}
				break;
			case ID:
			case SEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DpackParser.ID, 0); }
		public TerminalNode SEL() { return getToken(DpackParser.SEL, 0); }
		public TerminalNode DOT() { return getToken(DpackParser.DOT, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEL) {
				{
				setState(196);
				match(SEL);
				setState(197);
				match(DOT);
				}
			}

			setState(200);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(DpackParser.EQ, 0); }
		public TerminalNode GTE() { return getToken(DpackParser.GTE, 0); }
		public TerminalNode GT() { return getToken(DpackParser.GT, 0); }
		public TerminalNode LTE() { return getToken(DpackParser.LTE, 0); }
		public TerminalNode LT() { return getToken(DpackParser.LT, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DpackListener ) ((DpackListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DpackVisitor ) return ((DpackVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GTE) | (1L << GT) | (1L << LTE) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u00cd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001:\b\u0001\n\u0001\f\u0001=\t\u0001\u0003\u0001?\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002F\b"+
		"\u0002\n\u0002\f\u0002I\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003U\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004Z\b\u0004\n\u0004\f\u0004]\t\u0004\u0001\u0004\u0003\u0004`\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"m\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bs\b\b\u0001\b\u0001\b"+
		"\u0001\b\u0003\bx\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u0081\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u0091\b\r\n\r\f\r\u0094\t\r\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0098\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u009d\b\u000e\n\u000e\f\u000e\u00a0\t\u000e\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00a4\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00ab\b\u0010\n\u0010\f\u0010\u00ae\t\u0010\u0003\u0010"+
		"\u00b0\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00bb\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u00bf\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u00c3\b\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00c7\b"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0000"+
		"\u0000\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0005\u0001\u0000\u0001\u0002\u0004"+
		"\u0000\u000f\u000f\u0011\u0011\u0013\u0013\u0015\u0019\u0001\u0000\u0004"+
		"\u0005\u0002\u0000\u0012\u0012\u0014\u0014\u0001\u0000\r\u0011\u00d2\u0000"+
		"1\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u0004C\u0001"+
		"\u0000\u0000\u0000\u0006T\u0001\u0000\u0000\u0000\bV\u0001\u0000\u0000"+
		"\u0000\na\u0001\u0000\u0000\u0000\fe\u0001\u0000\u0000\u0000\u000eh\u0001"+
		"\u0000\u0000\u0000\u0010n\u0001\u0000\u0000\u0000\u0012y\u0001\u0000\u0000"+
		"\u0000\u0014{\u0001\u0000\u0000\u0000\u0016\u0082\u0001\u0000\u0000\u0000"+
		"\u0018\u0086\u0001\u0000\u0000\u0000\u001a\u008a\u0001\u0000\u0000\u0000"+
		"\u001c\u0095\u0001\u0000\u0000\u0000\u001e\u00a3\u0001\u0000\u0000\u0000"+
		" \u00a5\u0001\u0000\u0000\u0000\"\u00b3\u0001\u0000\u0000\u0000$\u00b6"+
		"\u0001\u0000\u0000\u0000&\u00be\u0001\u0000\u0000\u0000(\u00c2\u0001\u0000"+
		"\u0000\u0000*\u00c6\u0001\u0000\u0000\u0000,\u00ca\u0001\u0000\u0000\u0000"+
		".0\u0003\u0002\u0001\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000"+
		"\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0001\u0001"+
		"\u0000\u0000\u000031\u0001\u0000\u0000\u000045\u0005\t\u0000\u00005>\u0005"+
		"\u001d\u0000\u00006;\u0005\t\u0000\u000078\u0005\u001b\u0000\u00008:\u0005"+
		"\t\u0000\u000097\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000>6\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@A\u0005\u001e\u0000\u0000AB\u0003\u0004"+
		"\u0002\u0000B\u0003\u0001\u0000\u0000\u0000CG\u0005!\u0000\u0000DF\u0003"+
		"\u0006\u0003\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JK\u0005\"\u0000\u0000K\u0005\u0001\u0000"+
		"\u0000\u0000LU\u0003\b\u0004\u0000MU\u0003\"\u0011\u0000NU\u0003\u0010"+
		"\b\u0000OU\u0003\u0014\n\u0000PU\u0003\u0016\u000b\u0000QU\u0003\u001c"+
		"\u000e\u0000RU\u0003 \u0010\u0000SU\u0005\f\u0000\u0000TL\u0001\u0000"+
		"\u0000\u0000TM\u0001\u0000\u0000\u0000TN\u0001\u0000\u0000\u0000TO\u0001"+
		"\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000"+
		"TR\u0001\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000U\u0007\u0001\u0000"+
		"\u0000\u0000VW\u0003\u000e\u0007\u0000W[\u0003\u0004\u0002\u0000XZ\u0003"+
		"\n\u0005\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000^`\u0003\f\u0006\u0000_^\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`\t\u0001\u0000\u0000\u0000ab\u0005\u0003\u0000"+
		"\u0000bc\u0003\u000e\u0007\u0000cd\u0003\u0004\u0002\u0000d\u000b\u0001"+
		"\u0000\u0000\u0000ef\u0005\u0003\u0000\u0000fg\u0003\u0004\u0002\u0000"+
		"g\r\u0001\u0000\u0000\u0000hl\u0007\u0000\u0000\u0000ij\u0005\u0006\u0000"+
		"\u0000jm\u0005\u000b\u0000\u0000km\u0003$\u0012\u0000li\u0001\u0000\u0000"+
		"\u0000lk\u0001\u0000\u0000\u0000m\u000f\u0001\u0000\u0000\u0000nw\u0003"+
		"*\u0015\u0000or\u0005\u001a\u0000\u0000ps\u0003(\u0014\u0000qs\u0005\f"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000sx\u0001"+
		"\u0000\u0000\u0000tu\u0003\u0012\t\u0000uv\u0003(\u0014\u0000vx\u0001"+
		"\u0000\u0000\u0000wo\u0001\u0000\u0000\u0000wt\u0001\u0000\u0000\u0000"+
		"x\u0011\u0001\u0000\u0000\u0000yz\u0007\u0001\u0000\u0000z\u0013\u0001"+
		"\u0000\u0000\u0000{|\u0003\u0018\f\u0000|\u0080\u0005\u001a\u0000\u0000"+
		"}\u0081\u0003&\u0013\u0000~\u0081\u0003\u0018\f\u0000\u007f\u0081\u0005"+
		"\f\u0000\u0000\u0080}\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000"+
		"\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0015\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0003*\u0015\u0000\u0083\u0084\u0005\u001a\u0000\u0000"+
		"\u0084\u0085\u0003\u0018\f\u0000\u0085\u0017\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005\u0007\u0000\u0000\u0087\u0088\u0005\u000b\u0000\u0000\u0088"+
		"\u0089\u0003\u001a\r\u0000\u0089\u0019\u0001\u0000\u0000\u0000\u008a\u0092"+
		"\u0005\t\u0000\u0000\u008b\u008c\u0005\u001c\u0000\u0000\u008c\u0091\u0005"+
		"\t\u0000\u0000\u008d\u008e\u0005\u001f\u0000\u0000\u008e\u008f\u0005\b"+
		"\u0000\u0000\u008f\u0091\u0005 \u0000\u0000\u0090\u008b\u0001\u0000\u0000"+
		"\u0000\u0090\u008d\u0001\u0000\u0000\u0000\u0091\u0094\u0001\u0000\u0000"+
		"\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000"+
		"\u0000\u0093\u001b\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000"+
		"\u0000\u0095\u0097\u0007\u0002\u0000\u0000\u0096\u0098\u0005\u000b\u0000"+
		"\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009e\u0003\u001e\u000f"+
		"\u0000\u009a\u009b\u0005\u001b\u0000\u0000\u009b\u009d\u0003\u001e\u000f"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000"+
		"\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000"+
		"\u0000\u009f\u001d\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a4\u0003*\u0015\u0000\u00a2\u00a4\u0005\n\u0000\u0000"+
		"\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u001f\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003*\u0015\u0000\u00a6"+
		"\u00af\u0005\u001d\u0000\u0000\u00a7\u00ac\u0003(\u0014\u0000\u00a8\u00a9"+
		"\u0005\u001b\u0000\u0000\u00a9\u00ab\u0003(\u0014\u0000\u00aa\u00a8\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001"+
		"\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00a7\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0005\u001e\u0000\u0000\u00b2!\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0003*\u0015\u0000\u00b4\u00b5\u0007\u0003\u0000"+
		"\u0000\u00b5#\u0001\u0000\u0000\u0000\u00b6\u00ba\u0003*\u0015\u0000\u00b7"+
		"\u00b8\u0003,\u0016\u0000\u00b8\u00b9\u0003(\u0014\u0000\u00b9\u00bb\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bb%\u0001\u0000\u0000\u0000\u00bc\u00bf\u0003(\u0014"+
		"\u0000\u00bd\u00bf\u0005\n\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000"+
		"\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\'\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c3\u0005\b\u0000\u0000\u00c1\u00c3\u0003*\u0015\u0000\u00c2\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3)\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0005\u000b\u0000\u0000\u00c5\u00c7\u0005"+
		"\u001c\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005"+
		"\t\u0000\u0000\u00c9+\u0001\u0000\u0000\u0000\u00ca\u00cb\u0007\u0004"+
		"\u0000\u0000\u00cb-\u0001\u0000\u0000\u0000\u00161;>GT[_lrw\u0080\u0090"+
		"\u0092\u0097\u009e\u00a3\u00ac\u00af\u00ba\u00be\u00c2\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
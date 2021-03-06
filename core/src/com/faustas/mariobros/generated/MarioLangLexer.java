// Generated from MarioLang.g4 by ANTLR 4.3
package com.faustas.mariobros.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MarioLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OR=1, AND=2, EQ=3, NEQ=4, GT=5, LT=6, GTEQ=7, LTEQ=8, PLUS=9, MINUS=10, 
		MULT=11, DIV=12, MOD=13, POW=14, NOT=15, SCOL=16, ASSIGN=17, OPAR=18, 
		CPAR=19, OBRACE=20, CBRACE=21, TRUE=22, FALSE=23, NIL=24, IF=25, ELSE=26, 
		WHILE=27, LOG=28, SLEEP=29, JUMP=30, GO_RIGHT=31, GO_LEFT=32, FIRE=33, 
		ID=34, INT=35, FLOAT=36, STRING=37, COMMENT=38, SPACE=39, OTHER=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('"
	};
	public static final String[] ruleNames = {
		"OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
		"MULT", "DIV", "MOD", "POW", "NOT", "SCOL", "ASSIGN", "OPAR", "CPAR", 
		"OBRACE", "CBRACE", "TRUE", "FALSE", "NIL", "IF", "ELSE", "WHILE", "LOG", 
		"SLEEP", "JUMP", "GO_RIGHT", "GO_LEFT", "FIRE", "ID", "INT", "FLOAT", 
		"STRING", "COMMENT", "SPACE", "OTHER"
	};


	public MarioLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MarioLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u00ff\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\7#\u00c8\n#\f#\16#\u00cb\13#\3$\6$\u00ce\n$\r$\16$\u00cf\3%\6%"+
		"\u00d3\n%\r%\16%\u00d4\3%\3%\7%\u00d9\n%\f%\16%\u00dc\13%\3%\3%\6%\u00e0"+
		"\n%\r%\16%\u00e1\5%\u00e4\n%\3&\3&\3&\3&\7&\u00ea\n&\f&\16&\u00ed\13&"+
		"\3&\3&\3\'\3\'\7\'\u00f3\n\'\f\'\16\'\u00f6\13\'\3\'\3\'\3(\3(\3(\3(\3"+
		")\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3\2\b\5\2C\\aac|\6\2\62;C\\aac|\3"+
		"\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u0107\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5V\3\2\2"+
		"\2\7Y\3\2\2\2\t\\\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21f\3\2\2"+
		"\2\23i\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35s\3\2"+
		"\2\2\37u\3\2\2\2!w\3\2\2\2#y\3\2\2\2%{\3\2\2\2\'}\3\2\2\2)\177\3\2\2\2"+
		"+\u0081\3\2\2\2-\u0083\3\2\2\2/\u0088\3\2\2\2\61\u008e\3\2\2\2\63\u0092"+
		"\3\2\2\2\65\u0095\3\2\2\2\67\u009a\3\2\2\29\u00a0\3\2\2\2;\u00a4\3\2\2"+
		"\2=\u00aa\3\2\2\2?\u00af\3\2\2\2A\u00b8\3\2\2\2C\u00c0\3\2\2\2E\u00c5"+
		"\3\2\2\2G\u00cd\3\2\2\2I\u00e3\3\2\2\2K\u00e5\3\2\2\2M\u00f0\3\2\2\2O"+
		"\u00f9\3\2\2\2Q\u00fd\3\2\2\2ST\7~\2\2TU\7~\2\2U\4\3\2\2\2VW\7(\2\2WX"+
		"\7(\2\2X\6\3\2\2\2YZ\7?\2\2Z[\7?\2\2[\b\3\2\2\2\\]\7#\2\2]^\7?\2\2^\n"+
		"\3\2\2\2_`\7@\2\2`\f\3\2\2\2ab\7>\2\2b\16\3\2\2\2cd\7@\2\2de\7?\2\2e\20"+
		"\3\2\2\2fg\7>\2\2gh\7?\2\2h\22\3\2\2\2ij\7-\2\2j\24\3\2\2\2kl\7/\2\2l"+
		"\26\3\2\2\2mn\7,\2\2n\30\3\2\2\2op\7\61\2\2p\32\3\2\2\2qr\7\'\2\2r\34"+
		"\3\2\2\2st\7`\2\2t\36\3\2\2\2uv\7#\2\2v \3\2\2\2wx\7=\2\2x\"\3\2\2\2y"+
		"z\7?\2\2z$\3\2\2\2{|\7*\2\2|&\3\2\2\2}~\7+\2\2~(\3\2\2\2\177\u0080\7}"+
		"\2\2\u0080*\3\2\2\2\u0081\u0082\7\177\2\2\u0082,\3\2\2\2\u0083\u0084\7"+
		"v\2\2\u0084\u0085\7t\2\2\u0085\u0086\7w\2\2\u0086\u0087\7g\2\2\u0087."+
		"\3\2\2\2\u0088\u0089\7h\2\2\u0089\u008a\7c\2\2\u008a\u008b\7n\2\2\u008b"+
		"\u008c\7u\2\2\u008c\u008d\7g\2\2\u008d\60\3\2\2\2\u008e\u008f\7p\2\2\u008f"+
		"\u0090\7k\2\2\u0090\u0091\7n\2\2\u0091\62\3\2\2\2\u0092\u0093\7k\2\2\u0093"+
		"\u0094\7h\2\2\u0094\64\3\2\2\2\u0095\u0096\7g\2\2\u0096\u0097\7n\2\2\u0097"+
		"\u0098\7u\2\2\u0098\u0099\7g\2\2\u0099\66\3\2\2\2\u009a\u009b\7y\2\2\u009b"+
		"\u009c\7j\2\2\u009c\u009d\7k\2\2\u009d\u009e\7n\2\2\u009e\u009f\7g\2\2"+
		"\u009f8\3\2\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3\7i\2"+
		"\2\u00a3:\3\2\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7"+
		"g\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7r\2\2\u00a9<\3\2\2\2\u00aa\u00ab"+
		"\7l\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7o\2\2\u00ad\u00ae\7r\2\2\u00ae"+
		">\3\2\2\2\u00af\u00b0\7i\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7a\2\2\u00b2"+
		"\u00b3\7t\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7i\2\2\u00b5\u00b6\7j\2\2"+
		"\u00b6\u00b7\7v\2\2\u00b7@\3\2\2\2\u00b8\u00b9\7i\2\2\u00b9\u00ba\7q\2"+
		"\2\u00ba\u00bb\7a\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be"+
		"\7h\2\2\u00be\u00bf\7v\2\2\u00bfB\3\2\2\2\u00c0\u00c1\7h\2\2\u00c1\u00c2"+
		"\7k\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7g\2\2\u00c4D\3\2\2\2\u00c5\u00c9"+
		"\t\2\2\2\u00c6\u00c8\t\3\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00caF\3\2\2\2\u00cb\u00c9\3\2\2\2"+
		"\u00cc\u00ce\t\4\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0H\3\2\2\2\u00d1\u00d3\t\4\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00da\7\60\2\2\u00d7\u00d9\t\4\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u00e4\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\7\60\2\2\u00de"+
		"\u00e0\t\4\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00d2\3\2\2\2\u00e3"+
		"\u00dd\3\2\2\2\u00e4J\3\2\2\2\u00e5\u00eb\7$\2\2\u00e6\u00ea\n\5\2\2\u00e7"+
		"\u00e8\7$\2\2\u00e8\u00ea\7$\2\2\u00e9\u00e6\3\2\2\2\u00e9\u00e7\3\2\2"+
		"\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7$\2\2\u00efL\3\2\2\2\u00f0\u00f4"+
		"\7%\2\2\u00f1\u00f3\n\6\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f7\u00f8\b\'\2\2\u00f8N\3\2\2\2\u00f9\u00fa\t\7\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00fc\b(\2\2\u00fcP\3\2\2\2\u00fd\u00fe\13\2\2\2\u00fe"+
		"R\3\2\2\2\f\2\u00c9\u00cf\u00d4\u00da\u00e1\u00e3\u00e9\u00eb\u00f4\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
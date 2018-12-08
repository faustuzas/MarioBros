// Generated from MarioLang.g4 by ANTLR 4.3
package com.faustas.mariobros.generated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MarioLangParser}.
 */
public interface MarioLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(@NotNull MarioLangParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(@NotNull MarioLangParser.BooleanAtomContext ctx);

	/**
	 * Enter a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(@NotNull MarioLangParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(@NotNull MarioLangParser.IdAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#log}.
	 * @param ctx the parse tree
	 */
	void enterLog(@NotNull MarioLangParser.LogContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#log}.
	 * @param ctx the parse tree
	 */
	void exitLog(@NotNull MarioLangParser.LogContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#go_right}.
	 * @param ctx the parse tree
	 */
	void enterGo_right(@NotNull MarioLangParser.Go_rightContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#go_right}.
	 * @param ctx the parse tree
	 */
	void exitGo_right(@NotNull MarioLangParser.Go_rightContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#go_left}.
	 * @param ctx the parse tree
	 */
	void enterGo_left(@NotNull MarioLangParser.Go_leftContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#go_left}.
	 * @param ctx the parse tree
	 */
	void exitGo_left(@NotNull MarioLangParser.Go_leftContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(@NotNull MarioLangParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(@NotNull MarioLangParser.Condition_blockContext ctx);

	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(@NotNull MarioLangParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(@NotNull MarioLangParser.AtomExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(@NotNull MarioLangParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(@NotNull MarioLangParser.AdditiveExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#sleep}.
	 * @param ctx the parse tree
	 */
	void enterSleep(@NotNull MarioLangParser.SleepContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#sleep}.
	 * @param ctx the parse tree
	 */
	void exitSleep(@NotNull MarioLangParser.SleepContext ctx);

	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull MarioLangParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull MarioLangParser.ParExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(@NotNull MarioLangParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(@NotNull MarioLangParser.UnaryMinusExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stat(@NotNull MarioLangParser.While_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stat(@NotNull MarioLangParser.While_statContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#fire}.
	 * @param ctx the parse tree
	 */
	void enterFire(@NotNull MarioLangParser.FireContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#fire}.
	 * @param ctx the parse tree
	 */
	void exitFire(@NotNull MarioLangParser.FireContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull MarioLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull MarioLangParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(@NotNull MarioLangParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(@NotNull MarioLangParser.If_statContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterJump(@NotNull MarioLangParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitJump(@NotNull MarioLangParser.JumpContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull MarioLangParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull MarioLangParser.StatContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull MarioLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull MarioLangParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull MarioLangParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull MarioLangParser.OrExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNilAtom(@NotNull MarioLangParser.NilAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNilAtom(@NotNull MarioLangParser.NilAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull MarioLangParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull MarioLangParser.ParseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(@NotNull MarioLangParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(@NotNull MarioLangParser.RelationalExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(@NotNull MarioLangParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(@NotNull MarioLangParser.NumberAtomContext ctx);

	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(@NotNull MarioLangParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(@NotNull MarioLangParser.NotExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(@NotNull MarioLangParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(@NotNull MarioLangParser.StringAtomContext ctx);

	/**
	 * Enter a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(@NotNull MarioLangParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(@NotNull MarioLangParser.MultiplicationExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link MarioLangParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(@NotNull MarioLangParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarioLangParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(@NotNull MarioLangParser.Stat_blockContext ctx);

	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(@NotNull MarioLangParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(@NotNull MarioLangParser.PowExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(@NotNull MarioLangParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(@NotNull MarioLangParser.EqualityExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull MarioLangParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull MarioLangParser.AndExprContext ctx);
}
// Generated from MarioLang.g4 by ANTLR 4.3
package com.faustas.mariobros.generated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MarioLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MarioLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull MarioLangParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull MarioLangParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog(@NotNull MarioLangParser.LogContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#go_right}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGo_right(@NotNull MarioLangParser.Go_rightContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#go_left}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGo_left(@NotNull MarioLangParser.Go_leftContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(@NotNull MarioLangParser.Condition_blockContext ctx);

	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull MarioLangParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull MarioLangParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#sleep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSleep(@NotNull MarioLangParser.SleepContext ctx);

	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull MarioLangParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(@NotNull MarioLangParser.UnaryMinusExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#while_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(@NotNull MarioLangParser.While_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#fire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFire(@NotNull MarioLangParser.FireContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull MarioLangParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(@NotNull MarioLangParser.If_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#jump}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump(@NotNull MarioLangParser.JumpContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull MarioLangParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull MarioLangParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull MarioLangParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilAtom(@NotNull MarioLangParser.NilAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull MarioLangParser.ParseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull MarioLangParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull MarioLangParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull MarioLangParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link MarioLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull MarioLangParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull MarioLangParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link MarioLangParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(@NotNull MarioLangParser.Stat_blockContext ctx);

	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(@NotNull MarioLangParser.PowExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull MarioLangParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MarioLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull MarioLangParser.AndExprContext ctx);
}
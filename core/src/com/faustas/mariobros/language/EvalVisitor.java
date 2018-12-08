package com.faustas.mariobros.language;

import com.faustas.mariobros.events.PlayerFireEvent;
import com.faustas.mariobros.events.PlayerGoLeftEvent;
import com.faustas.mariobros.events.PlayerGoRightEvent;
import com.faustas.mariobros.events.PlayerJumpEvent;
import com.faustas.mariobros.generated.MarioLangBaseVisitor;
import com.faustas.mariobros.generated.MarioLangParser;
import com.faustas.mariobros.tools.EventDispatcher;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class EvalVisitor extends MarioLangBaseVisitor<Value> {
    private final EventDispatcher eventDispatcher = EventDispatcher.getInstance();

    // used to compare floating point numbers
    private static final double SMALL_VALUE = 0.00000000001;

    private Map<String, Value> memory = new HashMap<>();

    @Override
    public Value visitAssignment(MarioLangParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value = this.visit(ctx.expr());
        return memory.put(id, value);
    }

    @Override
    public Value visitIdAtom(MarioLangParser.IdAtomContext ctx) {
        String id = ctx.getText();
        Value value = memory.get(id);
        if(value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
        return value;
    }

    @Override
    public Value visitStringAtom(MarioLangParser.StringAtomContext ctx) {
        String str = ctx.getText();

        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(MarioLangParser.NumberAtomContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(MarioLangParser.BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNilAtom(MarioLangParser.NilAtomContext ctx) {
        return new Value(null);
    }

    @Override
    public Value visitParExpr(MarioLangParser.ParExprContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitPowExpr(MarioLangParser.PowExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(MarioLangParser.UnaryMinusExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(-value.asDouble());
    }

    @Override
    public Value visitNotExpr(MarioLangParser.NotExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(!value.asBoolean());
    }

    @Override
    public Value visitMultiplicationExpr(@NotNull MarioLangParser.MultiplicationExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case MarioLangParser.MULT:
                return new Value(left.asDouble() * right.asDouble());
            case MarioLangParser.DIV:
                return new Value(left.asDouble() / right.asDouble());
            case MarioLangParser.MOD:
                return new Value(left.asDouble() % right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + MarioLangParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAdditiveExpr(@NotNull MarioLangParser.AdditiveExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case MarioLangParser.PLUS:
                return left.isDouble() && right.isDouble() ?
                        new Value(left.asDouble() + right.asDouble()) :
                        new Value(left.asString() + right.asString());
            case MarioLangParser.MINUS:
                return new Value(left.asDouble() - right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + MarioLangParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitRelationalExpr(@NotNull MarioLangParser.RelationalExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case MarioLangParser.LT:
                return new Value(left.asDouble() < right.asDouble());
            case MarioLangParser.LTEQ:
                return new Value(left.asDouble() <= right.asDouble());
            case MarioLangParser.GT:
                return new Value(left.asDouble() > right.asDouble());
            case MarioLangParser.GTEQ:
                return new Value(left.asDouble() >= right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + MarioLangParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitEqualityExpr(@NotNull MarioLangParser.EqualityExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case MarioLangParser.EQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE) :
                        new Value(left.equals(right));
            case MarioLangParser.NEQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE) :
                        new Value(!left.equals(right));
            default:
                throw new RuntimeException("unknown operator: " + MarioLangParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAndExpr(MarioLangParser.AndExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visitOrExpr(MarioLangParser.OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() || right.asBoolean());
    }

    @Override
    public Value visitLog(MarioLangParser.LogContext ctx) {
        Value value = this.visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    @Override
    public Value visitGo_right(MarioLangParser.Go_rightContext ctx) {
        Value value = this.visit(ctx.expr());
        IntStream.range(0, value.asDouble().intValue())
                .forEach(i -> eventDispatcher.dispatch(new PlayerGoRightEvent()));

        return Value.VOID;
    }

    @Override
    public Value visitGo_left(MarioLangParser.Go_leftContext ctx) {
        Value value = this.visit(ctx.expr());
        IntStream.range(0, value.asDouble().intValue())
                .forEach(i -> eventDispatcher.dispatch(new PlayerGoLeftEvent()));

        return Value.VOID;
    }

    @Override
    public Value visitSleep(MarioLangParser.SleepContext ctx) {
        Value value = this.visit(ctx.expr());

        try {
            Thread.sleep(value.asDouble().intValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Value.VOID;
    }

    @Override
    public Value visitJump(MarioLangParser.JumpContext ctx) {
        eventDispatcher.dispatch(new PlayerJumpEvent());
        return Value.VOID;
    }

    @Override
    public Value visitFire(MarioLangParser.FireContext ctx) {
        eventDispatcher.dispatch(new PlayerFireEvent());
        return Value.VOID;
    }

    @Override
    public Value visitIf_stat(MarioLangParser.If_statContext ctx) {
        List<MarioLangParser.Condition_blockContext> conditions =  ctx.condition_block();
        boolean evaluatedBlock = false;

        for(MarioLangParser.Condition_blockContext condition : conditions) {
            Value evaluated = this.visit(condition.expr());

            if(evaluated.asBoolean()) {
                evaluatedBlock = true;

                this.visit(condition.stat_block());
                break;
            }
        }

        if(!evaluatedBlock && ctx.stat_block() != null) {
            // evaluate the else-stat_block (if present == not null)
            this.visit(ctx.stat_block());
        }

        return Value.VOID;
    }

    @Override
    public Value visitWhile_stat(MarioLangParser.While_statContext ctx) {
        Value value = this.visit(ctx.expr());

        while(value.asBoolean()) {
            this.visit(ctx.stat_block());

            value = this.visit(ctx.expr());
        }

        return Value.VOID;
    }
}

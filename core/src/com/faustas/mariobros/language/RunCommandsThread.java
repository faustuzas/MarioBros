package com.faustas.mariobros.language;

import com.faustas.mariobros.generated.MarioLangLexer;
import com.faustas.mariobros.generated.MarioLangParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class RunCommandsThread implements Runnable {
    private String commands;

    public Thread runCommands (String commands) {
        this.commands = commands;

        Thread thread = new Thread(this);
        thread.start();

        return thread;
    }

    @Override
    public void run() {
        try {
            MarioLangLexer lexer = new MarioLangLexer(new ANTLRInputStream(new ByteArrayInputStream(commands.getBytes())));
            MarioLangParser parser = new MarioLangParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.parse();
            EvalVisitor visitor = new EvalVisitor();
            visitor.visit(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

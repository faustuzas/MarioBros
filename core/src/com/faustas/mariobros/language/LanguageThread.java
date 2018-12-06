package com.faustas.mariobros.language;

import com.faustas.mariobros.generated.MarioLangLexer;
import com.faustas.mariobros.generated.MarioLangParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class LanguageThread implements Runnable {
    private Thread t;

    private boolean isRunning = true;

    public LanguageThread() {
        this.t = new Thread(this);
    }

    public void stop() {
        isRunning = false;
    }

    public Thread start() {
        t.start();

        return t;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                MarioLangLexer lexer = new MarioLangLexer(new ANTLRFileStream("test.mario"));
                MarioLangParser parser = new MarioLangParser(new CommonTokenStream(lexer));
                ParseTree tree = parser.parse();
                EvalVisitor visitor = new EvalVisitor();
                visitor.visit(tree);

                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

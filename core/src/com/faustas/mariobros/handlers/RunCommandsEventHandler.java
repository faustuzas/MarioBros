package com.faustas.mariobros.handlers;

import com.faustas.mariobros.events.RunCommandsEvent;
import com.faustas.mariobros.language.RunCommandsThread;

public class RunCommandsEventHandler implements Handler<RunCommandsEvent> {

    @Override
    public void onEvent(RunCommandsEvent event) {
        RunCommandsThread thread = new RunCommandsThread();

        thread.runCommands(event.getCommands());
    }
}

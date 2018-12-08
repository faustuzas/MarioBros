package com.faustas.mariobros.events;

public class RunCommandsEvent extends AbstractEvent {
    private String commands;

    public RunCommandsEvent(String commands) {
        this.commands = commands;
    }

    public String getCommands() {
        return commands;
    }
}

package com.yanport.ihoover;

import java.util.Arrays;

public enum Command {
    RIGHT('D'),
    LEFT('G'),
    FORWARD('A');

    private final char command;
    Command(char command) {
        this.command = command;
    }

    public static Command parseCommand(char instruction) {
        return Arrays.stream(Command.values())
                .filter(command -> instruction == command.command)
                .findFirst()
                .orElseThrow()
        ;
    }
}
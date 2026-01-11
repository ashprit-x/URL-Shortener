package org.example.commands;

import java.util.Map;

public class CommandExecutor {

    private final Map<String, Command> commands;

    public CommandExecutor(Map<String, Command> commands) {
        this.commands = commands;
    }

    public void execute(String[] input) throws CommandException {
        if (commands.containsKey(input[0])) {
            Command cmd = commands.get(input[0]);
            cmd.execute(input);
            return;
        }

        throw new CommandException("Unknown Command");
    }
}

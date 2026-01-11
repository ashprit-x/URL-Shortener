package org.example.commands;

import java.util.Map;

/**
 *
 */
public class CommandExecutor {

    private final Map<String, Command> commands;

    public CommandExecutor(Map<String, Command> commands) {
        this.commands = commands;
    }

    /**
     * @param input from CLI
     * @return output to be outputted to the CLI
     * @throws CommandException when required args differ or execution fails
     */
    public String execute(String[] input) throws CommandException {
        if (commands.containsKey(input[0])) {
            Command cmd = commands.get(input[0]);
            return cmd.execute(input);
        }

        throw new CommandException("Unknown Command");
    }
}

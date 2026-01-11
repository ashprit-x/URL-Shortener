package org.example.commands;

import java.util.Map;

public class HelpCommand extends BaseCommand {

    private final Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) throws CommandException {
        requireArgs(args, 1);
        commands.forEach((name, cmd) ->
                System.out.println(name + " -> " + cmd.help())
        );
    }

    @Override
    public String help() {
        return "help : returns all commands and how to use them";
    }
}

package org.example.commands;

public abstract class BaseCommand implements Command {
    protected void requireArgs(String[] args, int num) throws CommandException {
        if (args.length != (num)) {
            throw new CommandException(args[0] + " requires exactly " + (num) + " argument(s)");
        }
    }
}

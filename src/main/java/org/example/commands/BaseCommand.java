package org.example.commands;

/**
 * Base class for CLI commands
 * Subclasses use the requireArgs to enforce an exact argument count.
 */
public abstract class BaseCommand implements Command {
    protected void requireArgs(String[] args, int num) throws CommandException {
        if (args.length != (num)) {
            throw new CommandException(args[0] + " requires exactly " + (num) + " argument(s)");
        }
    }
}

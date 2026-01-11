package org.example.commands;

/**
 * Representation of a singular CLI command.
 */
public interface Command {
    /**
     * Executes the command with the provided arguments
     *
     * @param args command-line arguments
     * @return to be outputted to user
     * @throws CommandException if arguments are invalid or execution fails
     */
    String execute(String[] args) throws CommandException;

    /**
     * @return a short help string describing the command.
     */
    String help();
}

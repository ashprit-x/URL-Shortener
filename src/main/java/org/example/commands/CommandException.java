package org.example.commands;

/**
 * Exception to be thrown when command cannot function correctly.
 */
public class CommandException extends Exception {
    public CommandException (String message) {
        super(message);
    }
}

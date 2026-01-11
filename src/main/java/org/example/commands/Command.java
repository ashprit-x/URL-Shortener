package org.example.commands;

public interface Command {
    void execute(String[] args) throws CommandException;
    String help();
}

package org.example.commands.impl;

import org.example.commands.BaseCommand;
import org.example.commands.Command;
import org.example.commands.CommandException;
import org.example.utils.URLFormatter;

import java.util.Map;

/**
 * Lists all the commands available and how they work
 */
public class HelpCommand extends BaseCommand {

    private final Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String execute(String[] args) throws CommandException {
        requireArgs(args, 1);
        return URLFormatter.formatCommands(commands);
    }

    @Override
    public String help() {
        return "help : returns all commands and how to use them";
    }
}

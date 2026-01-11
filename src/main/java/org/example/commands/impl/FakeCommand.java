package org.example.commands.impl;

import org.example.commands.BaseCommand;

/**
 * Mock implementation of command used for testing CommandExecutor
 */
public class FakeCommand extends BaseCommand {

    private boolean executed = false;

    @Override
    public String execute(String[] args) {
        executed = true;
        return "";
    }

    @Override
    public String help() {
        return "fake";
    }

    public boolean wasExecuted() {
        return executed;
    }
}

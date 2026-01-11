package org.example.commands.impl;

import org.example.commands.BaseCommand;

/**
 * Mock implementation of command used for testing CommandExecutor.
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

    /**
     * <b>Note:</b> Only used in testing
     *
     * @return boolean if the command was executed
     */
    public boolean wasExecuted() {
        return executed;
    }
}

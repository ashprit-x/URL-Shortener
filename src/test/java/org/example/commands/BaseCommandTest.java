package org.example.commands;

import org.junit.Test;

public class BaseCommandTest {

    private static class TestCommand extends BaseCommand {
        @Override
        public String execute(String[] args) throws CommandException {
            requireArgs(args, 1);
            return "ok";
        }

        @Override
        public String help() {
            return "";
        }
    }

    @Test(expected = CommandException.class)
    public void throwsWhenWrongNumberOfArgs() throws CommandException {
        new TestCommand().execute(new String[]{"cmd", "extra"});
    }

    @Test
    public void doesNotThrowWhenCorrectNumberOfArgs() throws CommandException {
        new TestCommand().execute(new String[]{"cmd"});
    }
}

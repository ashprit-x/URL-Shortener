package org.example.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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

    public void throwsWhenWrongNumberOfArgs() throws CommandException {
        assertThrows(CommandException.class, () -> {
            new TestCommand().execute(new String[]{"cmd", "extra"});
        });
    }

    @Test
    public void doesNotThrowWhenCorrectNumberOfArgs() throws CommandException {
        new TestCommand().execute(new String[]{"cmd"});
    }
}

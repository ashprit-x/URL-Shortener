package org.example.commands;

import org.example.commands.impl.FakeCommand;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CommandExecutorTest {

    @Test
    public void execute_knownCommand_isExecuted() throws CommandException {
        FakeCommand fake = new FakeCommand();

        Map<String, Command> commands = new HashMap<>();
        commands.put("test", fake);

        CommandExecutor executor = new CommandExecutor(commands);

        executor.execute(new String[]{"test"});

        assertTrue(fake.wasExecuted());
    }

    @Test
    public void execute_unknownCommand_throws() throws CommandException {
        CommandExecutor executor =
                new CommandExecutor(new HashMap<>());

        assertThrows(CommandException.class, () -> {
            executor.execute(new String[]{"some-non-existent-command"});
        });
    }
}

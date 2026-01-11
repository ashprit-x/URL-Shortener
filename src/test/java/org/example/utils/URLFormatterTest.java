package org.example.utils;

import org.example.commands.Command;
import org.example.commands.CommandException;
import org.example.commands.impl.FakeCommand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class URLFormatterTest {

    @Test
    public void formatUrls_formatsUrlEntriesCorrectly() {
        Map<String, String> map = new HashMap<>();
        map.put("https://a.com", "a");
        map.put("https://b.com", "b");

        List<Map.Entry<String, String>> data =
                new ArrayList<>(map.entrySet());

        String result = URLFormatter.formatUrls(data);

        assertEquals(
                "https://a.com -> a\nhttps://b.com -> b\n",
                result
        );
    }

    @Test
    public void formatCommands_formatsCommandsCorrectly() {
        Map<String, Command> commands = new HashMap<>();
        commands.put("help", new FakeCommand());

        String result = URLFormatter.formatCommands(commands);

        assertEquals(
                "help -> fake\n",
                result
        );
    }
}

package org.example.commands.impl;

import org.example.repository.InMemoryURLRepository;
import org.example.service.URLShortenerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListCommandTest {

    @Test
    public void list_returnsEntries() throws Exception{
        URLShortenerService service =
                new URLShortenerService(new InMemoryURLRepository());

        service.shorten("https://a.com");
        service.shorten("https://b.com");

        ListCommand cmd = new ListCommand(service);
        String result = cmd.execute(new String[]{"list"});

        assertTrue(result.contains("https://a.com"));
        assertTrue(result.contains("https://b.com"));
    }
}

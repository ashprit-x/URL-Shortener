package org.example.commands.impl;

import org.example.repository.InMemoryURLRepository;
import org.example.service.URLShortenerService;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetCommandTest {

    @Test
    public void get_returnsOriginalUrl() throws Exception {
        URLShortenerService service =
                new URLShortenerService(new InMemoryURLRepository());

        String code = service.shorten("https://example.com");

        GetCommand cmd = new GetCommand(service);
        String result = cmd.execute(new String[]{"get", code});

        assertEquals("https://example.com", result);
    }
}

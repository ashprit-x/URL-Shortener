package org.example.commands.impl;

import org.example.repository.InMemoryURLRepository;
import org.example.service.URLShortenerService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortenCommandTest {

    @Test
    public void shorten_returnsCode() throws Exception {
        URLShortenerService service =
                new URLShortenerService(new InMemoryURLRepository());

        ShortenCommand cmd = new ShortenCommand(service);

        String result = cmd.execute(new String[]{"shorten", "https://example.com"});

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}

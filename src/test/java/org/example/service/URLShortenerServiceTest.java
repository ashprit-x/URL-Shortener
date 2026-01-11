package org.example.service;

import org.example.repository.InMemoryURLRepository;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class URLShortenerServiceTest {

    @Test
    public void shorten_sameUrl_returnsSameCode() {
        URLShortenerService service = new URLShortenerService(new InMemoryURLRepository());

        String code1 = service.shorten("https://example.com");
        String code2 = service.shorten("https://example.com");

        assertEquals(code1, code2);
    }

    @Test
    public void shorten_differentUrls_returnDifferentCodes() {
        URLShortenerService service = new URLShortenerService(new InMemoryURLRepository());

        String code1 = service.shorten("https://a.com");
        String code2 = service.shorten("https://b.com");

        assertNotEquals(code1, code2);
    }

    @Test
    public void getOriginalUrl_returnsOriginal() {
        URLShortenerService service = new URLShortenerService(new InMemoryURLRepository());

        String code = service.shorten("https://example.com");
        Optional<String> original = service.getOriginalUrl(code);

        assertTrue(original.isPresent());
        assertEquals("https://example.com", original.get());
    }

    @Test
    public void getOriginalUrl_unknownCode_returnsErrorMessage() {
        URLShortenerService service = new URLShortenerService(new InMemoryURLRepository());

        Optional<String> result = service.getOriginalUrl("does-not-exist");

        assertFalse(result.isPresent());
    }
}


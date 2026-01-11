package org.example.repository;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryURLRepositoryTest {

    @Test
    public void findUrlByCode_returnsUrl() {
        URLRepository repo = new InMemoryURLRepository();

        repo.save("https://example.com", "abc");

        Optional<String> result = repo.findUrlByCode("abc");

        assertTrue(result.isPresent());
        assertEquals("https://example.com", result.get());
    }

    @Test
    public void findCodeByUrl_returnsCode() {
        URLRepository repo = new InMemoryURLRepository();

        repo.save("https://example.com", "abc");

        Optional<String> result = repo.findCodeByUrl("https://example.com");

        assertTrue(result.isPresent());
        assertEquals("abc", result.get());
    }

    @Test
    public void findUrlByCode_missingCode_returnsEmpty() {
        URLRepository repo = new InMemoryURLRepository();

        assertFalse(repo.findUrlByCode("missing").isPresent());
    }

    @Test
    public void findAll_returnsAllEntries() {
        URLRepository repo = new InMemoryURLRepository();

        repo.save("https://a.com", "a");
        repo.save("https://b.com", "b");

        List<Map.Entry<String, String>> all = repo.findAll();

        assertEquals(2, all.size());
    }
}

package org.example.repository;

import java.util.*;

public class InMemoryURLRepository implements URLRepository {

    private final HashMap<String, String> urlMap;
    private final HashMap<String, String> reverseMap;

    public InMemoryURLRepository() {
        this.urlMap = new HashMap<>();
        this.reverseMap = new HashMap<>();
    }

    @Override
    public Optional<String> findCodeByUrl(String url) {
        if (urlMap.containsKey(url)) {
            return Optional.of(urlMap.get(url));
        }

        return Optional.empty();
    }

    @Override
    public Optional<String> findUrlByCode(String code) {
        if (reverseMap.containsKey(code)) {
            return Optional.of(reverseMap.get(code));
        }

        return Optional.empty();
    }

    @Override
    public void save(String url, String code) {
        urlMap.put(url, code);
        reverseMap.put(code, url);
    }

    @Override
    public List<Map.Entry<String, String>> findAll() {
        return new ArrayList<>(urlMap.entrySet());
    }
}

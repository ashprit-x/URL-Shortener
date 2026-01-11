package org.example.service;

import org.example.utils.URLCodeGenerator;
import org.example.repository.URLRepository;

import java.util.*;

/*
*  A class that implements methods to shorten a URL.
*/
public class URLShortenerService implements URLShortenerInterface {

    private final URLRepository repository;
    private final URLCodeGenerator generator;

    public URLShortenerService(URLRepository repository) {
        this.repository = repository;
        generator = new URLCodeGenerator();
    }

    @Override
    public String shorten(String url) {
        Optional<String> shortenedURL = repository.findCodeByUrl(url);

        if (shortenedURL.isPresent()) {
            return shortenedURL.get();
        }

        String code = generator.generateUrlEnding();

        repository.save(url, code);

        return code;
    }

    @Override
    public Optional<String> getOriginalUrl(String url) {
        return repository.findUrlByCode(url);
    }

    @Override
    public List<Map.Entry<String, String>> listUrls() {
        return repository.findAll();
    }
}

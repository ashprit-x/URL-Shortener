package org.example.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface URLShortenerInterface {
    String shorten(String url);
    Optional<String> getOriginalUrl(String url);
    List<Map.Entry<String, String>> listUrls();
}

package org.example.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface URLRepository {
    Optional<String> findCodeByUrl(String url);

    Optional<String> findUrlByCode(String code);

    void save(String url, String code);

    List<Map.Entry<String, String>> findAll();
}

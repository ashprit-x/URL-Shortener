import org.example.repository.InMemoryURLRepository;
import org.example.service.URLShortenerService;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class URLShortenerTest {

    private static final String BASE_URL = "www.somerandomwebsite.com";

    // class in test
    URLShortenerService urlShortener = new URLShortenerService(new InMemoryURLRepository());


    @Test
    public void shorten_multipleURLs_returnsNoCollisions() {
        int calls = 5000;

        String temp = "";

        for (int i = 0; i < calls; i++) {
            Optional<String> original = urlShortener.getOriginalUrl(temp);
            assertFalse(original.isPresent());
            String shortened = urlShortener.shorten(BASE_URL + Integer.toString(i));
        }

    }
}

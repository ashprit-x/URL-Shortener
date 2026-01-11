package org.example.utils;

public class URLCodeGenerator {
    private static final int base = 62;
    private static final String baseCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private long counter;

    public URLCodeGenerator() {
        counter = 1L;
    }

    public String generateUrlEnding() {
        StringBuilder stringBuilder = new StringBuilder();
        while (counter > 0) {
            stringBuilder.append(baseCharacters.charAt((int) (counter % base)));
            counter /= base;
        }
        counter++;
        return stringBuilder.toString();
    }
}

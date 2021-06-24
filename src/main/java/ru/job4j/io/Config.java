package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(line -> !line.startsWith("#") && line.length() > 0)
                    .forEach(line -> {
                        String[] keyValue = line.trim().split("=");
                        if (keyValue.length < 2) {
                            throw new IllegalArgumentException();
                        }
                        values.put(keyValue[0], keyValue[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }
}

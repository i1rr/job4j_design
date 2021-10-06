package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(cachingDir + key))) {
            String str = in.readLine();
            while (str != null && !str.isEmpty()) {
                text.append(str);
                text.append(System.lineSeparator());
                str = in.readLine();
            }
        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
       return text.toString();
    }
}
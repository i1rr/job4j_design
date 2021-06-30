package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateVisitor extends SimpleFileVisitor<Path> {
    private final HashMap<FileProperty, List<Path>> rsl = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        FileProperty fp = new FileProperty(attrs.size(), file.getFileName().toString());
        if (rsl.containsKey(fp)) {
            rsl.get(fp).add(file.toAbsolutePath());
        } else {
            rsl.put(fp, new ArrayList<>());
            rsl.get(fp).add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

    public void printDuplicates() {
        System.out.println("Found duplicates: ");
        for (Map.Entry<FileProperty, List<Path>> entry : rsl.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println();
                System.out.println(entry.getKey().getName());
                for (Path path : entry.getValue()) {
                    System.out.println(path.normalize());
                }
            }
        }
    }
}

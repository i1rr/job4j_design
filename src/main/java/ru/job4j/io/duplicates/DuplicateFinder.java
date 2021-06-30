package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;

public class DuplicateFinder {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "To start the scanner you have to enter the path as argument\n"
                    + "Example for Mac users: java -jar /Users/Admin/IdeaProjects/\n"
            + "Example for Windows users: java -jar C:/IdeaProjects/");
        }
        String path = args[0];
        DuplicateVisitor dv = new DuplicateVisitor();
      Files.walkFileTree(Path.of(path), dv);
      dv.printDuplicates();

    }
}
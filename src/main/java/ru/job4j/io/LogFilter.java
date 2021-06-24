package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(ArrayList<String> list, String filter) {
        return list.stream()
                .filter(filterBy -> filterBy.contains(filter))
                .collect(Collectors.toList());
    }

    public static ArrayList<String> getFileToArrayList(String file) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String str : log) {
                out.write(str + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = getFileToArrayList("log.txt");
        List<String> log = filter(list, "404");
        for (String string : log) {
            System.out.println(string);
        }
        save(log, "404.txt");
    }
}

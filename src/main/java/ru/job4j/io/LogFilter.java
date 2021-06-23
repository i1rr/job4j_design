package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
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

    public static void main(String[] args) {
        ArrayList<String> list = getFileToArrayList("log.txt");
        List<String> log = filter(list, "404");
        for (String string : log) {
            System.out.println(string);
        }
    }
}

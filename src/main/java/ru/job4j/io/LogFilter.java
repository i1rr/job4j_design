package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {

    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            rsl = in.lines().filter(filter -> filter.contains("404"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String str : log) {
                out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static List<String> filter(ArrayList<String> list, String filter) {
        return list.stream()
                .filter(filterBy -> filterBy.contains(filter))
                .collect(Collectors.toList());
    }

    @Deprecated
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
        List<String> list = filter("log.txt");
        for (String string : list) {
            System.out.println(string);
        }
        save(list, "404.txt");
    }
}

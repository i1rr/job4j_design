package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;

public class Analysis {
    private boolean serverUp = true;
    private final StringBuilder log = new StringBuilder();

    public void unavailable(String source, String target) {
        getServiceStatusReport(source);
        generateReport(target);
    }

    public ArrayList<String> load(String file) {
        ArrayList<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().filter(line -> !line.isEmpty()).forEach(rsl::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void generateReport(String target) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
                out.println(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getServiceStatusReport(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines().forEach(line -> {
                        if (serverUp && (line.startsWith("400") || line.startsWith("500"))) {
                            log.append(secondValue(line)).append(";");
                            serverUp = false;
                        }
                        if (!serverUp && (line.startsWith("200") || line.startsWith("300"))) {
                            log.append(secondValue(line)).append(";")
                                    .append(System.lineSeparator());
                            serverUp = true;
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String secondValue(String string) {
        return (string).split(" ")[1];
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip
                     = new ZipOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(
                        new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out
                             = new BufferedInputStream(
                        new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip
                     = new ZipOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out
                         = new BufferedInputStream(
                                 new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException(
                    "Use the following template to start the application:\n"
                            + "java -jar zip.jar -d=c:\\windows\\System32\\ -e=txt -o=windows.zip\n"
                            + System.lineSeparator()
                            + "-d - directory_path - the one we are going to archive \n"
                            + "-e - exclude - files that we want to exclude (any ->.txt)\n"
                            + "-o - output - output file name.");
        }
        Zip zip = new Zip();
        ArgsName an = ArgsName.of(args);
        Path input = Paths.get(an.get("d"));
        File output = new File(an.get("o"));
        zip.packFiles(Search.search(input, pred -> !pred.toFile()
                .getName()
                .endsWith(an.get("e"))), output);
    }
}
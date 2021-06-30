package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalysisTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTempReport() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analysis log = new Analysis();
        log.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> rsl = List.of("10:57:01;10:59:01;", "11:01:02;11:02:02;");
        assertThat(log.load(target.getAbsolutePath()), is(rsl));
    }

    @Test
    public void whenReport1is2reboot() {
        Analysis log = new Analysis();
        String report = "./Data/ServerStatusLog/report1.txt";
        List<String> rsl = List.of("10:57:01;10:59:01;", "11:01:02;11:02:02;");
        log.unavailable("./Data/ServerStatusLog/serverLog1.txt", report);
        assertThat(log.load(report), is(rsl));
    }

    @Test
    public void whenReport2is1reboot() {
        Analysis log = new Analysis();
        String report = "./Data/ServerStatusLog/report2.txt";
        List<String> rsl = List.of("10:57:01;11:02:02;");
        log.unavailable("./Data/ServerStatusLog/serverLog2.txt", report);
        assertThat(log.load(report), is(rsl));
    }

}
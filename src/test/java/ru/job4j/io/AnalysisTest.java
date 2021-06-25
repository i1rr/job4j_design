package ru.job4j.io;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalysisTest {

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
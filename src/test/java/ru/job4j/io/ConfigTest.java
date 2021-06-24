package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./Data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./Data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalArgumentException() {
        String path = "./Data/pair_with_IllegalArgumentException.properties";
        Config config = new Config(path);
        config.load();
    }
}
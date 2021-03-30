package ru.job4j.test;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestTesta {

    @Test
    public void test1() {
        Testa test = new Testa();
        assertThat(test.test(), is("test"));
    }
}
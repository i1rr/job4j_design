package ru.job4j.test;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ForCodeCovTest {

    @Test
    public void boom() {
        assertThat(new ForCodeCov().boom(), is(44));
    }
}
package ru.job4j.kiss;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaxMinTest {

    private final static List<Integer> INTEGER_LIST = List.of(2, 18, 4, 44, 9, 21, 3, 5);

    @Test
    public void whenGettingMaxValue() {
        MaxMin mm = new MaxMin();
        assertThat(mm.max(INTEGER_LIST, Integer::compareTo), is(44));
    }

    @Test
    public void whenGettingMinValue() {
        MaxMin mm = new MaxMin();
        assertThat(mm.min(INTEGER_LIST, Integer::compareTo), is(2));
    }
}
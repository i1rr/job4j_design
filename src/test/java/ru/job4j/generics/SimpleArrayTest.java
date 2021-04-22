package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleArrayTest {
    @Test
    public void whenAddElement() {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        assertThat(test.get(0), is(1));
    }

    @Test
    public void whenSetElement() {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.set(1, 44);
        assertThat(test.get(1), is(44));
    }

    @Test
    public void whenRemoveElement() {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.remove(0);
        assertThat(test.get(1), is(3));
        assertThat(test.get(4), is(nullValue()));
    }

    @Test
    public void whenIteratorAround() {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        Iterator<Integer> it = test.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
    }
}
package ru.job4j.collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddThenRemoveException() {
        SimpleArray<Integer> arr = new SimpleArray<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.remove(3);
        arr.get(3);
    }

    @Test
    public void whenAddAndRemove() {
        SimpleArray<Integer> arr = new SimpleArray<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.remove(2);
        assertThat(arr.get(2), is(4));
    }

    @Test
    public void whenSet() {
        SimpleArray<Integer> arr = new SimpleArray<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.set(2, 44);
        assertThat(arr.get(2), is(44));
    }
}
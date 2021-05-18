package ru.job4j.collection.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterateTooFar() {
        SimpleSet<String> ss = new SimpleSet<>();
        assertTrue(ss.add("kolbasa"));
        assertTrue(ss.add("venik"));
        assertTrue(ss.add("drova"));
        Iterator<String> it = ss.iterator();
        assertThat(it.next(), is("kolbasa"));
        assertThat(it.next(), is("venik"));
        assertThat(it.next(), is("drova"));
        assertFalse(it.hasNext());
        it.next();
    }
}
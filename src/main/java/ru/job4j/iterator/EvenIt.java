package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {

    private final int[] data;
    private int pointer;

    public EvenIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (pointer < data.length && data[pointer] % 2 != 0) {
            pointer++;
        }
        return pointer < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (int) data[pointer++];
    }
}

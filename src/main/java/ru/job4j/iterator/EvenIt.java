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
        boolean check;
        for (int i = pointer; i < data.length; i++) {
           check = data[i] % 2 == 0;
           if (check) {
               break;
           } else {
               ++pointer;
           }
        }
        return pointer < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[pointer++];
    }
}

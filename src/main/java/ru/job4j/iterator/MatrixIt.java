package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int exArrPointer = 0;
    private int inArrPointer = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (exArrPointer < data.length && data[exArrPointer].length == inArrPointer) {
                exArrPointer++;
                inArrPointer = 0;
            }
        return exArrPointer < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[exArrPointer][inArrPointer++];
    }
}
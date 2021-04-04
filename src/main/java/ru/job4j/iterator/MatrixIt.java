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
        while (exArrPointer < data.length) {
            if (inArrPointer < data[exArrPointer].length) {
                return true;
            }
                exArrPointer++;
                inArrPointer = 0;
            }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[exArrPointer][inArrPointer++];
    }
}
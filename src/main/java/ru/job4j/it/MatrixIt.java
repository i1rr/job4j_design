package ru.job4j.it;

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
        for (int[] rr : data) {
            if (exArrPointer < data.length && inArrPointer < data[exArrPointer].length) {
                return true;
            } else {
                if (exArrPointer < data.length) {
                    exArrPointer++;
                    inArrPointer = 0;
                }
            }
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
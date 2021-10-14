package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] simpleArray;
    private int pointer = 0;
    private final int arrayLength;

    public SimpleArray(int size) {
        this.simpleArray = (T[]) new Object[size];
        this.arrayLength = size;
    }

    public void add(T model) {
            simpleArray[pointer++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, pointer);
        simpleArray[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, pointer);
        System.arraycopy(simpleArray, index + 1, simpleArray, index, pointer - index - 1);
        simpleArray[pointer] = null;
        pointer--;
    }

    public T get(int index) {
        Objects.checkIndex(index, pointer);
        return simpleArray[index];
    }

    public static void main(String[] args) {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        for (int i = 0; i < test.arrayLength; i++) {
            System.out.println(test.get(i));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int itPointer = 0;

            @Override
            public boolean hasNext() {
                return itPointer < pointer;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return simpleArray[itPointer++];
            }
        };
    }
}

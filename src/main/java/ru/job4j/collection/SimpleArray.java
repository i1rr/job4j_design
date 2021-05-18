package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private T[] container;
    private int size;
    private int modCount = 0;

    public SimpleArray() {
        container = (T[]) new Object[10];
    }

    public SimpleArray(int arrSize) {
        container = (T[]) new Object[arrSize];
    }

    private void arrayGrow() {
        container = Arrays.copyOf(container, container.length + (container.length >> 1));
    }

    public T get(int index) {
        return container[Objects.checkIndex(index, size)];
    }

    public void add(T model) {
        if (size == container.length) {
            arrayGrow();
        }
        container[size++] = model;
        modCount++;
    }

    public void set(int index, T model) {
        container[Objects.checkIndex(index, size)] = model;
        modCount++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        container[--size] = null;
        modCount++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int pointer = 0;
            private final int expectedModCount = modCount;

            @Override
            public  boolean hasNext() {
                return pointer < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return container[pointer++];
            }
        };
    }
}

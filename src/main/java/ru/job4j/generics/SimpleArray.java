package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] simpleArray;
    private int index = 0;
    private final int arrayLength;

    public SimpleArray(int size) {
        this.simpleArray = (T[]) new Object[size];
        this.arrayLength = size;
    }

    //Adds an element to the next empty cell
    public void add(T model) {
            simpleArray[index++] = model;
    }

    //Replaces an element[index] with provided model
    public void set(int index, T model) {
        indexCheck();
        simpleArray[index] = model;
    }

    //Removes an element and merges the array
    public void remove(int index) {
        indexCheck();
        System.arraycopy(simpleArray, index + 1, simpleArray, index, arrayLength - index - 1);
        simpleArray[arrayLength - 1] = null;
    }

    //Returns an element with provided index
    public T get(int index) {
        indexCheck();
        return simpleArray[index];
    }

    //Lazy usage of method
    private void indexCheck() {
        Objects.checkIndex(index, arrayLength + 1);
    }

    //Также, реализуйте интерфейс Iterable<T> - метод iterator() возвращает итератор,
    // предназначенный для обхода данной структуры.
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

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < arrayLength;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return simpleArray[index++];
            }
        };
    }
}

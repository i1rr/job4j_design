package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private final SimpleArray<T> set = new SimpleArray<>();

    private int valueToIndex(T value) {
        for (int i = 0; i < set.getSize(); i++) {
            if (Objects.equals(set.get(i), value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        return valueToIndex(value) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}

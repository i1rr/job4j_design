package ru.job4j.collection.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private int hash(int hashCode) {
        return (hashCode >>> capacity);
    }

    private int indexFor(int hash) {
        return hash & table.length - 1;
    }

    public void expand() {
        capacity *= 1.75;
        MapEntry<K, V>[] temp = table;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> rr : table) {
            if (rr != null) {
                put(rr.key, rr.value);
            }
        }
    }

    public int size() {
        return count;
    }

    @Override
    public boolean put(K key, V value) {
        int index = indexFor(hash(key.hashCode()));
        if (count / LOAD_FACTOR >= table.length) {
            expand();
        }

        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
        } else {
            if (key.equals(table[index].getKey())) {
                table[index].setValue(value);
            } else {
                return false;
            }
        }
        modCount++;
            return true;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && key.equals(table[index].getKey())) {
            return table[index].getValue();
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && key.equals(table[index].getKey())) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return new Iterator<>() {
            private int pointer = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                while (pointer < table.length && table[pointer] == null) {
                    pointer++;
                }
                return pointer < table.length;
            }

            @Override
            public MapEntry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return table[pointer++];
            }
        };
    }

    public static class MapEntry<K, V> {
         private final K key;
         private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

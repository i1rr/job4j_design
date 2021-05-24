package ru.job4j.collection.map;

public interface Map<K, V> extends Iterable<SimpleMap.MapEntry<K, V>> {

        boolean put(K key, V value);

        V get(K key);

        boolean remove(K key);
}

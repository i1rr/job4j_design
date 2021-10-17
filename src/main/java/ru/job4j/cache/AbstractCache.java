package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V value;
        if (cache.get(key) == null) {
            value = load(key);
            put(key, value);
        } else {
            value = cache.get(key).get();
        }
        return value;
    }

    protected abstract V load(K key);
}
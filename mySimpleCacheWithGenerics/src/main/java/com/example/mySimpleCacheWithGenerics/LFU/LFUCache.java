package com.example.mySimpleCacheWithGenerics.LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache<K, V> {
    Map<K, V> values;               // key, value
    Map<K, Integer> counts;               // key, count
    Map<Integer, LinkedHashSet<K>> lists; // count, list->keys
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        values = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(0, new LinkedHashSet<>());
    }

    public void put(K key, V value) {
        if (cap <= 0) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key); // trigger the reorder
            return;
        }
        if (values.size() >= cap) {
            K evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            values.remove(evict);
            counts.remove(evict);
        }
        values.put(key, value);
        counts.put(key, 0);
        min = 0;
        lists.get(0).add(key);
    }

    public V get(K key) {
        if (!values.containsKey(key)) {
            return null;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if (count == min && lists.get(count).size() == 0) {
            min++;
        }
        if (!lists.containsKey(count+1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }
        lists.get(count + 1).add(key);
        return values.get(key);
    }

    @Override
    public String toString() {
        return "LFUCache{" + "values=" + values + ", counts=" + counts + ", lists=" + lists + ", cap=" + cap + ", min=" + min + "}";
    }
}

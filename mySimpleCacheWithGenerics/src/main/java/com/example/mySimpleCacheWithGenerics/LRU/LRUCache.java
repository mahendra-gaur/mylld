package com.example.mySimpleCacheWithGenerics.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;
    private final DoublyLinkedList<K, V> cacheList;
    private final Map<K, Node<K, V>> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheList = new DoublyLinkedList<>();
        this.cacheMap = new HashMap<>();
    }

    public V get(K key) {
        Node<K, V> node = cacheMap.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> existingNode = cacheMap.get(key);
        if (existingNode != null) {
            existingNode.value = value;
            moveToHead(existingNode);
            return;
        }

        Node<K, V> newNode = new Node<>(key, value);
        cacheList.addFirst(newNode);
        cacheMap.put(key, newNode);

        if (cacheList.size() > capacity) {
            removeLeastRecentlyUsed();
        }
    }

    private void moveToHead(Node<K, V> node) {
        cacheList.remove(node);
        cacheList.addFirst(node);
    }

    private void removeLeastRecentlyUsed() {
        Node<K, V> tail = cacheList.removeLast();
        cacheMap.remove(tail.key);
    }

    @Override
    public String toString() {
        return "LRUCache{" + "capacity=" + capacity + ", cacheList=" + cacheList + "}";
    }
}

package com.example.mySimpleLUR.cache;

class Node<K, V> {
    final K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "key=" + key + ", value=" + value + "}";
    }
}
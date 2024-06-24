package com.example.mySimpleLUR;

import com.example.mySimpleLUR.cache.LRUCache;

public class Main {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache);
        cache.put(4, "D");
        cache.put(5, "E");
        System.out.println(cache);
        cache.get(3);
        System.out.println(cache);
        cache.put(6, "F");
        System.out.println(cache);
    }

}

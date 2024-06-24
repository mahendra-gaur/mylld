package com.example.mySimpleCacheWithGenerics.LFU;

public class Main {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(5);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache);

        cache.get(1);
        System.out.println(cache);

        cache.get(3);
        cache.get(3);
        System.out.println(cache);

        cache.put(4, "D");
        cache.put(5, "E");
        cache.put(6, "F");
        System.out.println(cache);

        cache.get(4);
        System.out.println(cache);

        cache.put(7, "G");
        System.out.println(cache);
        cache.get(7);
        System.out.println(cache);

        cache.get(6);
        cache.get(6);
        cache.get(6);
        System.out.println(cache);

        cache.put(8, "H");
        System.out.println(cache);
    }

}

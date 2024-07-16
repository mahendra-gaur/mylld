package org.example;

import org.example.controller.ICache;
import org.example.controller.TtlCache;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ICache<String, String> cache = new TtlCache<String, String>(100);
        cache.put("1" , "Apple", 2000);
        cache.put("2" , "Banana", 5000);
        cache.put("3" , "Pomegranate", 5000);
        cache.put("4" , "Kiwi", 5000);

        System.out.println(cache.get("1"));
        System.out.println(cache.get("4"));
        Thread.sleep(3000);
        System.out.println(cache.get("1"));
        Thread.sleep(3000);
    }
}
package com.dinesh.sequencedCollection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

public class MapExample {

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");

        SequencedMap<String, Integer> sequencedMap = new LinkedHashMap<>();

        sequencedMap.putFirst("Two", 2);
        sequencedMap.putLast("Three", 3);
        sequencedMap.putLast("Four", 4);
        sequencedMap.put("Five", 5);

        System.out.println("Initial map elements :" + sequencedMap);

        Map.Entry firstEntry = sequencedMap.firstEntry();
        System.out.println("First Entry : " + firstEntry);
        //Before  java 21 code will be below one
        //firstEntry = sequencedMap.entrySet().iterator().next();
        //System.out.println(firstEntry);

        var lastEntry = sequencedMap.lastEntry();
        System.out.println("Last Entry : " + lastEntry);

        System.out.println("Elements in map : " + sequencedMap);

        var removedFirstEntry = sequencedMap.pollFirstEntry();
        System.out.println("Removed First Entry : " + removedFirstEntry);
        var removedLastEntry = sequencedMap.pollLastEntry();
        System.out.println("Removed Last Entry : " + removedLastEntry);

        System.out.println("Elements in map after first and last elements removal : " + sequencedMap);

        sequencedMap.putLast("Twenty", 20);

        var reversedMap = sequencedMap.reversed();

        System.out.println("Reversed Map : " + reversedMap);
        System.out.println("----------------------------------------------");
    }
}

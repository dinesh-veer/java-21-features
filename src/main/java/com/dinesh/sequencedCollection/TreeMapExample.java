package com.dinesh.sequencedCollection;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");

        SortedMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("Two",2);
        treeMap.put("Hundred",100);
        treeMap.put("Twelve",12);
        treeMap.put("Seven",7);

        System.out.println("Initial TreeMap: " + treeMap);

        var firstEntry = treeMap.firstEntry();
        //Old method
        //var firstEntry = treeMap.entrySet().iterator().next();
        System.out.println("First Entry: " + firstEntry);

        var lastEntry = treeMap.lastEntry();
        System.out.println("Last Entry: " + lastEntry);

        System.out.println("Elements in Map: " + treeMap);

        var removeFirstEntry = treeMap.pollFirstEntry();
        //Old way to remove
        //var removedFirstEntry = treeMap.remove(firstEntry.getKey());
        System.out.println("First removed entry: " + removeFirstEntry);

        var removeLastEntry = treeMap.pollLastEntry();
        System.out.println("Last removed entry: " + removeLastEntry);

        System.out.println("Map after first and last elements removal: " + treeMap);

        treeMap.put("Three",3);
        treeMap.put("Four",4);

        var reversedMap = treeMap.reversed();
        System.out.println("Reversed Map: " + reversedMap);

        try{
            treeMap.putFirst("Nine",9);
        }catch (UnsupportedOperationException e){
            System.out.println("Exception caught: " + e);
            System.out.println("Reason: Cannot control insertion position in a sorted map!");
        }

        System.out.println("---------------------------------------------");
    }
}

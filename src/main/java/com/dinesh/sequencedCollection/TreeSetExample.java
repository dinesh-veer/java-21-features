package com.dinesh.sequencedCollection;

import javax.naming.OperationNotSupportedException;
import java.util.SequencedSet;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");

        SequencedSet<String> sequencedSet = new TreeSet<>();

        sequencedSet.add("David");
        sequencedSet.add("Bob");
        sequencedSet.add("Charlie");
        sequencedSet.add("Alice");

        System.out.println("Sorted Set: " + sequencedSet);

        //Access can done in set in Set
        var firstElement = sequencedSet.getFirst();
        var lastElement = sequencedSet.getLast();
        System.out.println("First Element: " + firstElement + " Last Element: " + lastElement);

        //Reversal also can be done in Set
        System.out.println("Tree reversal Set :" + sequencedSet.reversed());

        //Modification based on place will fail
        try {
            sequencedSet.addFirst("Neomi");
        }catch (UnsupportedOperationException exception){
            System.out.println("Error :" +exception);
            System.out.println("Reason: Cannot control insertion position in a sorted set!");
        }
       System.out.println("------------------------------------------------");

    }
}

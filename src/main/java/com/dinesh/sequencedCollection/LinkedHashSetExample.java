package com.dinesh.sequencedCollection;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class LinkedHashSetExample {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");

        SequencedSet<String> sequencedSet = new LinkedHashSet<>();

        sequencedSet.addFirst("Alice");
        sequencedSet.addLast("Bob");
        sequencedSet.addLast("Charlie");
        sequencedSet.addLast("David");

        System.out.println("Intial SequencedSet: " + sequencedSet);

        var removedFirstElement = sequencedSet.removeFirst();
        System.out.println("Removed First Element: " + removedFirstElement);
        var removedLastElement = sequencedSet.removeLast();
        System.out.println("Removed Last Element: " + removedLastElement);

        System.out.println("After first and last element removal given sequencedSet: " + sequencedSet);

        sequencedSet.addFirst("Xavida");
        sequencedSet.addFirst("Roger");

        System.out.println("After adding some elements sequencedSet: " + sequencedSet);

        var reversedSet = sequencedSet.reversed();
        System.out.println("Reversed Set: " + reversedSet);

        System.out.println("--------------------------------------------------");
    }
}

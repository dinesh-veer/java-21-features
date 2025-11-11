package com.dinesh.sequencedCollection;

import java.util.ArrayDeque;
import java.util.SequencedCollection;

public class DequeExample {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");

        SequencedCollection<String> dequeExample = new ArrayDeque<>();

        dequeExample.addFirst("Alex");
        dequeExample.addLast("Bob");
        dequeExample.addLast("Carl");
        dequeExample.addLast("Dan");

        System.out.println("Names in Deque Example: " + dequeExample); //[Alex, Bob, Carl]

        System.out.println("First Element: " + dequeExample.getFirst());
        System.out.println("Last Element: " + dequeExample.getLast());

        dequeExample.removeFirst();
        dequeExample.removeLast();
        System.out.println("After removing first and last element: " + dequeExample);

        var reversedDeque = dequeExample.reversed();

        System.out.println("Reversed Deque: " + reversedDeque);

        reversedDeque.addFirst("Xavia");
        reversedDeque.addLast("John");

        System.out.println("After adding elements in Deque: " + reversedDeque);


        System.out.println("--------------------------------------------------");
   }
}

package com.dinesh.sequencedCollection;

import java.util.LinkedList;
import java.util.SequencedCollection;

public class ListExample {

    public static void main(String[] args) {

        System.out.println("--------------------------------------------------");

        SequencedCollection<Integer> list = new LinkedList<>();

        list.add(200);
        list.add(300);
        list.add(400);

        System.out.println("Initial list :" +list); //[200, 300, 400]

        Integer firstElement = list.getFirst();
        Integer lastElement = list.getLast();
        System.out.println(STR."First element :\{firstElement} Last element :\{lastElement}");

        list.addFirst(100);
        list.addLast(500);
        System.out.println("After adding first and last element 100 & 500 in list :" +list);

        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first and last element 100 & 500 in list :" +list);

        var reveredList = list.reversed();
        System.out.println("After reverse list :" +reveredList);

        reveredList.addLast(7000);
        reveredList.addFirst(50);
        System.out.println("After adding 7000 to last and 50 to first of list :" +reveredList);

        System.out.println("------------------------------------------------");
    }
}

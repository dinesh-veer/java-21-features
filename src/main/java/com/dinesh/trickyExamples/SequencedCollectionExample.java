package com.dinesh.trickyExamples;

import java.util.*;

public class SequencedCollectionExample {

    public static void main(String[] args) {

        //what is output ?
        SequencedCollection sc = new ArrayList<>(List.of(10, 20, 30));
        sc.addFirst(0);
        sc.addLast(40);
        System.out.println(sc); //output [0, 10, 20, 30, 40]

        //Below code gives compile time error
        //HashSet doesn't implements the SequencedSet
        //SequencedSet sequencedSet = new HashSet<Integer>();

        SequencedSet sequencedSet = new TreeSet<Integer>();
        sequencedSet.add(30);
        sequencedSet.add(10);
        sequencedSet.add(20);

        System.out.println(sequencedSet);
        //below code will give you UnsupportedOperationException
        try {
            sequencedSet.addFirst(1000);
            sequencedSet.addLast(200);
        }catch (UnsupportedOperationException e){
            System.out.println(e);
        }

        System.out.println(sequencedSet);//Output will be : [10, 20, 30]

    }
}

package com.dinesh.unnamed.patternAndVariables;

import java.util.List;
import java.util.Map;

public class UnnamedVariables {

    static void checkObject(Object object){
        switch (object){
            case Person(String name , _) -> System.out.println("Given person name :"+ name);
            case String _ -> System.out.println("Given object is string");
            case null -> System.out.println("Given object is null");
            default -> System.out.println("Given object doesnt need value further");
        }
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------------");

        var object = "This is string object";

        //if we don't need values further after object type checking
        if (object instanceof String _) {
            System.out.println("This is string object doesnt need value further");
        }

        Object person = new Person("Jonathan", 34);
        //some value of Person record is needed but others are not
        if (person instanceof Person(_, int age)) {
            System.out.println("Person name is not needed, his age is " + age);
        }

        checkObject(person);
        checkObject("string");
        checkObject(null);

        System.out.println("---------------------------------------------");

        Map<String, Integer> scores = Map.of("One", 1, "Two", 2, "Three", 3);

        // The '_' explicitly marks the value (score) as unused.
        scores.forEach((key, _) -> {
            System.out.println(key + " took the test.");
        });

        System.out.println("---------------------------------------------");

        List<String> list = List.of("One", "Two", "Three");

        try {
            list.get(10);
        }catch (IndexOutOfBoundsException _){//
            System.out.println("Exception happened ignoring exception variable");
        }

        var _ = 10;//it is allowed
       // System.out.println(_); // ❌ Compile-time error: '_' is unnamed
        System.out.println("---------------------------------------------");
    }
}

record Person(String name, int age) {}
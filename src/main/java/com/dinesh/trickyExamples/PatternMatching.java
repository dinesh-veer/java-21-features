package com.dinesh.trickyExamples;


record Point(int x, int y) {}

public class PatternMatching {


    static void test(Object obj) {
        if (obj instanceof Point(int _, int y)) {
            System.out.println(y); //output will be 10
        }

        //Will below code execute
//        if (obj instanceof Point(int x, int _)) {
//            System.out.println(_);
//        }
           //above will give you compile time error due to _ is not allowed.
           //error: cannot reference unnamed variable

        //Can you use _ as a loop variable?
//
//        for (int _ = 0; _ < 3; _++) { }
        //above code will give compile time error as _ is not allowed.
        //error: cannot reference unnamed variable
    }

    public static void main(String[] args) {
        test(new Point(5, 10));

        Object obj = "TRUE";


        switch (obj) {
            case String s when s.equalsIgnoreCase("true") -> System.out.println("Matched TRUE");
            case String s -> System.out.println("Just a string: " + s);
            default -> System.out.println("Unknown");
        }
        //Trick: The first case matches "TRUE" because of the guard.
        // Without the guard, it would fall into the second case.
    }

}

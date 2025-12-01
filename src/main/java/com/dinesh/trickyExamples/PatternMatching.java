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
    }

}

package com.dinesh.patternMatching.recordMatching;

import java.util.List;

record Point(int x, int y) {}
record ColorPoint(Point point, String color) {}
record GenericClass<T>(T t) {}

/**
 * This feature, which works hand-in-hand with Pattern Matching for switch,
 * allows you to deconstruct record objects.
 */
public class RecordPatternExample {

    private static void pointSum(Point point) {

        System.out.println("----------------------------------------------------");
        System.out.println("Print sum using old reference type :");

        if(point instanceof Point point1){
            var x = point.x();
            var y = point.y();

            System.out.println("Using old method for Sum : " +(x+y));
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Print sum using new reference type :");

        if(point instanceof Point(var x, var y)){
            System.out.println("Using new method for Sum : " +(x+y));
        }

        System.out.println("--------------------------------------------------");

    }


    static void testColorInstance() {

        System.out.println("--------------------------------------------------");
        var listOfObjects = List.of(
                new GenericClass<>(new Point(4,2)),
                new GenericClass<>(new ColorPoint( new Point(6, 4), "Pink")),
                new GenericClass<>("This is String"),
                new GenericClass<>(100)
        );

        for (var object : listOfObjects) {
            switch (object) {
                case GenericClass(Point( var x , var y )) -> {
                    System.out.printf("Point [%d,%d]%n", x, y);
                }
                case GenericClass(ColorPoint(Point(var x, var y), var color))->
                    System.out.printf("ColorPoint [%d,%d] with color %s%n", x, y,color);
                case GenericClass(String string)->
                    System.out.printf("String [%s]%n", string);

                default -> System.out.println("Nothing matched");
            }
        }

        System.out.println("--------------------------------------------------");
    }


    public static void main(String[] args) {
        var point = new Point(1, 2);
        var colorPoint = new ColorPoint(point, "red");

        pointSum(point);
        testColorInstance();
    }


}

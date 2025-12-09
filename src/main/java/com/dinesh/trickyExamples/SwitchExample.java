package com.dinesh.trickyExamples;

sealed interface Shape permits Circle, Rectangle {}
record Circle(double r) implements Shape {}
record Rectangle(double w, double h) implements Shape {}

public class SwitchExample {

    private static String printObjectType(Shape shape) {
        return switch (shape){
            case Circle circle -> "Circle";
            //This will gives you compile time error as needs to
            //Rectangle or default case is missing
            case Rectangle rectangle -> "Rectangle";
        };
    }
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        printObjectType(circle);
    }
}

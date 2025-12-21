package com.dinesh.trickyExamples;

public class PatternWithNull {
    public static void test(Object obj) {
        switch (obj) {
            case String s when s.length() >5 -> System.out.println("Long String");//Multiple conditions with string
            case String s -> System.out.println("Short String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Found a null!"); // New in Java 17+
            default -> System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        test(null);
    }
}
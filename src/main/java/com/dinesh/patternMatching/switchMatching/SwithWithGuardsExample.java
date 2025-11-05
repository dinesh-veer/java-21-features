package com.dinesh.patternMatching.switchMatching;

/**
 * Demonstrates Java 21's enhanced switch statement with:
 * - Null handling
 * - Multiple case labels
 * - Pattern matching with guards
 *
 * This example showcases how to use `switch` with type patterns and conditional guards
 * to simplify complex branching logic.
 */
public class SwithWithGuardsExample {

    /**
     * Uses a switch expression to evaluate the input string.
     * Handles:
     * - `null` values
     * - Multiple fixed string matches ("Dinesh", "Veer")
     * - Pattern matching with guards for "true"/"false" (case-insensitive)
     * - Default case for unmatched inputs
     *
     * @param string the input string to evaluate
     */
    static void switchWithMultipleValuesAndGuard(String string){

        switch (string){
            case null -> System.out.println("Given object is nulll");
            case  "Dinesh","Veer"  -> System.out.println("Given object is my name");
            case String str when str.equalsIgnoreCase("true")
                    ->System.out.println("Given object is true");
            case String str when str.equalsIgnoreCase("false") ->
                System.out.println("Given object is false");

            default -> System.out.println(STR."Given case come into default case, , given string \{string}");
        }
    }

    /**
     * Entry point of the program.
     * Tests the switch logic with various inputs including:
     * - null
     * - "True"
     * - "Dinesh"
     * - "welcome"
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        switchWithMultipleValuesAndGuard(null);
        switchWithMultipleValuesAndGuard("True");
        switchWithMultipleValuesAndGuard("Dinesh");
        switchWithMultipleValuesAndGuard("welcome");
        System.out.println("---------------------------------------------------");
    }
}

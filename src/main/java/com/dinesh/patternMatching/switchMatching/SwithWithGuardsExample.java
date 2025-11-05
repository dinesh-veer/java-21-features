package com.dinesh.patternMatching.switchMatching;

/**
 * Switch example with null, multiple values and guard
 *
 */
public class SwithWithGuardsExample {

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

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        switchWithMultipleValuesAndGuard(null);
        switchWithMultipleValuesAndGuard("True");
        switchWithMultipleValuesAndGuard("Dinesh");
        switchWithMultipleValuesAndGuard("welcome");
        System.out.println("---------------------------------------------------");
    }
}

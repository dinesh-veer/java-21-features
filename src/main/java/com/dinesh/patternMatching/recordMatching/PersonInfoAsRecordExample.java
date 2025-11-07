package com.dinesh.patternMatching.recordMatching;

record Address(String city, String country) {}
record Person(String name, Address address) {}

/**
 * The {@code PersonInfoAsRecordExample} class demonstrates the use of
 * <b>Record Patterns</b> introduced in Java 21 (JEP 440).
 * <p>
 * It defines two record types — {@code Address} and {@code Person} — and shows how
 * to use <b>nested pattern matching</b> with the {@code instanceof} operator
 * to destructure and extract values directly from record objects.
 * </p>
 *
 * <h3>Features demonstrated:</h3>
 * <ul>
 *   <li>Record declaration and automatic component handling</li>
 *   <li>Pattern matching using {@code instanceof}</li>
 *   <li>Nested record patterns</li>
 *   <li>Type inference using {@code var}</li>
 * </ul>
 *
 * <p>Requires Java 21 or later.</p>
 *
 * @author Dinesh
 * @since Java 21
 */
public class PersonInfoAsRecordExample {

    /**
     * Checks whether the given object is a {@code Person} record and, if so,
     * prints the person's name, city, and country using record pattern matching.
     * <p>
     * If the object is not a {@code Person}, a message is displayed indicating that.
     * </p>
     *
     * @param object the object to be checked and printed
     */
    private static void printInformation(Object object) {
        if (object instanceof Person( var name, Address(var city, var country)))
            System.out.println("Name:" +name + " City:" +city + " Country:" +country);
        else
            System.out.println("Object is not a Person.");
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------");

        Person person = new Person("Dinesh", new Address("Pune", "India"));
        printInformation(person);

        System.out.println("---------------------------------------------------------------");

        var person1 = new Person("Maria", new Address("New York", "USA"));
        printInformation(person1);

        System.out.println("----------------------------------------------------------------");

        var stringObject = "String object type";
        printInformation(stringObject);

        System.out.println("---------------------------------------------------------------");

    }

}

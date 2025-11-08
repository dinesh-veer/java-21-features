package com.dinesh.stringLiterals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.StringTemplate.*;
import static java.util.FormatProcessor.FMT;

/*
 *
 * In JEP 430, Java introduces multiple built-in template processors:
 * STR → creates a normal interpolated string
 *
 * FMT → formatted string (like String.format)
 *
 * RAW → Raw String Template, useful when you want to capture the template + expressions without resolving them
 *
 * JEP 430: String Templates (Preview)
 * https://openjdk.org/jeps/430
 *
 * */
public class StringLiteralExample {

    static String name = "Java 21";
    static String lastName ="Veer";
    static String firstName = "Dinesh";

    private static void singleLineStringExamples() {

        System.out.println("---------------------------------------------");
        //Single line examples
        String welcomeText = STR."Welcome to \{name}";
        System.out.println(welcomeText);

        var fullName = STR."\{firstName} \{lastName}";
        var schoolName = STR."\{lastName} , \{firstName}";

        System.out.println(STR."Full Name: \{fullName}");
        System.out.println(STR."School Name: \{schoolName}");
    }


    private static void multiLineStringExamples() {


        String welcomeText = STR."Welcome to \{name}";

        System.out.println("---------------------------------------------");

        //Multiline examples
        var htmlString = STR."""
                <html>
                    <head>
                        <title>\{name}</title>
                    </head>
                    <body>
                        <h1>\{welcomeText}</h1>
                    </body>
                </html>
                """;
        System.out.println(STR."HTML string: \{htmlString}");

        var jsonString = STR."""
                {
                    "firstName" : "\{firstName},
                    "lastName" : "\{lastName}",
                    "java-version" :21
                 }
                """;

        System.out.println(STR."Json example : \{jsonString}");
    }

    //Formatter in string literals
    private static void formatStringExample() throws SQLException {

        System.out.println("--------------------------------------------");

        String item1 = "Apples";
        int qty1 = 40;
        double price1 = 35.5;

        String item2 = "Milk";
        int qty2 = 11;
        double price2 = 52.75;

        String item3 = "Bread";
        int qty3 = 11;
        double price3 = 45.0;

        double total = qty1 * price1 + qty2 * price2 + qty3 * price3;

        String bill = FMT."""
                    Item         Qty     Price       Total
                    %-12s\{item1} %3d\{qty1}   %7.2f\{price1}     %8.2f\{qty1 * price1}
                    %-12s\{item2} %3d\{qty2}   %7.2f\{price2}     %8.2f\{qty2 * price2}
                    %-12s\{item3} %3d\{qty3}   %7.2f\{price3}     %8.2f\{qty3 * price3}
                    \{" ".repeat(18)}Grand Total: %8.2f\{total}
                    """;

        System.out.println(bill);
        System.out.println("--------------------------------------------");


        String user = "Robert'); DROP TABLE Students;--";

        StringTemplate st = RAW."SELECT * FROM users WHERE name = '\{user}'";
        // You can now validate and escape st.values() before building the final SQL string

        System.out.println("RAW example :" +st );
        System.out.println(st.fragments()); // [ "SELECT * FROM users WHERE name = '", "'" ]
        System.out.println(st.values());    // [ Robert'); DROP TABLE Students;-- ]

        // Below code sanitises sql statement
        /*
        Connection connection = DriverManager.getConnection("url", "username", "password");

        //Converting to safe query
        StringTemplate st1 = RAW."SELECT * FROM users WHERE name = \{user}";

        String sql = st.fragments().get(0) + "?" + st.fragments().get(1);

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, st.values().get(0).toString());

        // it will pass as data to query not sql statement
        //SELECT * FROM users WHERE name = ?
        //so will not execute drop statement.
        */
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) throws SQLException {

        singleLineStringExamples();
        multiLineStringExamples();
        formatStringExample();

    }

}

record Rectangle(String name, double width, double height) {
    double area() { return width * height; }
}

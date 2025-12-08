package com.dinesh.trickyExamples;

import static java.lang.StringTemplate.RAW;

public class StringTemplateExample {

    public static void main(String[] args) {

        String name = "java 21";

        //Difference between below temple and string
        StringTemplate stringTemplate = StringTemplate.of(STR."Welcome to \{name}");
        String string = STR."Welcome \{name}";

        System.out.println(string);//evaluated String produced by the processor STR
        System.out.println(stringTemplate);//template object containing fragments + values (not a String yet).


        //Difference between below
        String user = "Robert'); DROP TABLE Students;--";
        String withoutTemplate = STR."SELECT * FROM users WHERE name = '\{user}'";
        StringTemplate st = RAW."SELECT * FROM users WHERE name = '\{user}'";

        System.out.println(withoutTemplate);
        System.out.println(st.toString());
//        RAW creates a StringTemplate object; it doesn’t concatenate or send to DB.
//        You must explicitly validate and escape values before turning it into a String.
//        So this prevents SQL injection until you manually build and execute the query.



        int x = 10;
        int y = 20;

        // Looks like concatenation, but it's template interpolation
        String s = STR."Sum of \{x} + \{y} = \{x + y}"; //The expression inside \{} is evaluated immediately.
        System.out.println(s); // Output: Sum of 10 + 20 = 30
    }
}

package com.neurogine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Neurogine {

    public static void main(String[] args){
        String[] strArr= new String[] {"abc","an","","apple","bcd","","jk"};

        String nonEmptyOutput = Arrays.stream(strArr)
                .filter(str-> !str.isEmpty())
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        System.out.println("Convert string to uppercase and join them with comma: " + nonEmptyOutput);

        List<String> stringList = Arrays.stream(strArr)
                .filter(st->st.length()>2)
                .collect(Collectors.toList());

        System.out.println("List with String more than 2 characters: " + stringList);

        long startsWithA = Arrays.stream(strArr)
                .filter(st->st.startsWith("a"))
                .count();

        System.out.println("Number of String which starts with \"a\": " + startsWithA);

        long emptyStr = Arrays.stream(strArr)
                .filter(String::isEmpty)
                .count();

        System.out.println("Count of empty string: " + emptyStr);
    }
}

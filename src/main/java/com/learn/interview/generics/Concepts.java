package com.learn.interview.generics;

import java.util.ArrayList;
import java.util.List;

public class Concepts {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        List<String> stringList = List.of("abc", "def");
        //readList(integerList);
        //readList(stringList);

        List<? super Integer> someList = new ArrayList<>();
        addToList(someList);

        readList(someList);

        List<? extends Number> foo3 = new ArrayList<Integer>();

        //foo3.add(5);
    }

    private static void addToList(List<? super Integer> someList) {
        someList.add(1);
        someList.add(12);
        someList.add(13);
        someList.add(145);
    }


    public static void readList(List<?> genericList) {
        for (Object a: genericList) {
            System.out.println(a);
        }
    }


}

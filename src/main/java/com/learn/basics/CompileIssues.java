package com.learn.basics;

public class CompileIssues {

    public static void main(String[] args) {
        //float value = 102.0;

        /*var a = 15;
        var b = 10;
        CompileIssues.addToInt(a, b);
        System.out.println(a);*/


        var s1 = "Java";
        var s2 = "Java";
        var s3 = "Ja".concat("va");
        var s4 = s3.intern();
        var sb1 = new StringBuilder();
        sb1.append("Ja").append("va");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(sb1.toString() == s1);
        System.out.println(sb1.toString().equals(s1));

    }

    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
    }
}

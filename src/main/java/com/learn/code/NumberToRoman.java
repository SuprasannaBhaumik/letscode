package com.learn.code;

import java.util.HashMap;
import java.util.Map;

public class NumberToRoman {

    public static void main(String[] args) {
        System.out.println(NumberToRoman.intToRoman(58));
    }


    public static String intToRoman(int num) {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        StringBuilder romanText = new StringBuilder();

        if(romanMap.containsKey(num)) {
            return romanMap.get(num);
        }

        while(num > 0) {
            int noOfDigits = String.valueOf(num).toCharArray().length;
            int subtractor;
            if(noOfDigits == 4) {
                subtractor = (int)Math.pow(10, noOfDigits - 1);
            } else {
                subtractor = Integer.parseInt(Character.toString(String.valueOf(num).toCharArray()[0])) * (int)Math.pow(10, noOfDigits - 1);
            }
            if(romanMap.containsKey(subtractor)) {
                romanText.append(romanMap.get(subtractor));
            } else {
                romanText.append(getDigit(subtractor, noOfDigits, romanMap));
            }
            num = num - subtractor;
        }
        return romanText.toString();
    }

    private static String getDigit(int subtractor, int noOfDigits, Map<Integer, String> romanMap) {
        StringBuilder sb = new StringBuilder();

        int num = subtractor/(int)Math.pow(10, noOfDigits - 1);
        if (num > 5) {
            sb.append(romanMap.get(5*(int)Math.pow(10, noOfDigits - 1)));
            while(num > 5) {
                sb.append(romanMap.get((int)Math.pow(10, noOfDigits - 1)));
                num--;
            }
        } else {
            sb.append(romanMap.get((int)Math.pow(10, noOfDigits - 1)));
            while(num > 1) {
                sb.append(romanMap.get((int)Math.pow(10, noOfDigits - 1)));
                num--;
            }
        }
        return sb.toString();
    }

}

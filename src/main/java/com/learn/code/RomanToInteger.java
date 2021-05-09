package com.learn.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(RomanToInteger.romanToInt("MCMXCIV"));
    }

    public static Map<String, Integer> getMap () {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1 );
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);
        return romanMap;
    }
    public static int romanToInt(String s) {
        Map<String, Integer> romanMap = getMap();

        if(romanMap.containsKey(s)) {
            return romanMap.get(s);
        }

        char[] charArray = s.toCharArray();
        int i = 0;
        int count = 0;
        while(i<charArray.length) {
            if(charArray[i] == 'I' && i < charArray.length - 1) {
                if(charArray[i+1] == 'V' || charArray[i+1] == 'X') {
                    count += romanMap.get(Character.toString(charArray[i]) + Character.toString(charArray[i+1]));
                    i+=2;
                }  else {
                    count += romanMap.get(Character.toString(charArray[i]));
                    i++;
                }
            } else if (charArray[i] == 'X' && i < charArray.length - 1) {
                if(charArray[i+1] == 'L' || charArray[i+1] == 'C') {
                    count += romanMap.get(Character.toString(charArray[i]) + Character.toString(charArray[i+1]));
                    i+=2;;
                }  else {
                    count += romanMap.get(Character.toString(charArray[i]));
                    i++;
                }
            } else if (charArray[i] == 'C' && i < charArray.length - 1) {
                if(charArray[i+1] == 'D' || charArray[i+1] == 'M') {
                    count += romanMap.get(Character.toString(charArray[i]) + Character.toString(charArray[i+1]));
                    i+=2;
                }  else {
                    count += romanMap.get(Character.toString(charArray[i]));
                    i++;
                }
            } else {
                count += romanMap.get(Character.toString(charArray[i]));
                i++;
            }
        }
        return count;
    }
}

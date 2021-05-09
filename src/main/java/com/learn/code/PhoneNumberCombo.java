package com.learn.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PhoneNumberCombo {

    public static void main(String[] args) {
        System.out.println(PhoneNumberCombo.letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        Map<Integer, String> telephoneMap = getTelephoneMap();
        if(digits.equals("")){
            return resultList;
        } else if (digits.toCharArray().length == 1) {
            for ( char i: telephoneMap.get(Integer.parseInt(digits)).toCharArray()) {
                resultList.add(Character.toString(i));
            }
            return resultList;
        } else {
            char[] digitsArr = digits.toCharArray();
            List<String> actualValues = new ArrayList<>();
            for(char c: digitsArr) {
                actualValues.add(telephoneMap.get(Integer.parseInt(Character.toString(c))));
            }
           List<String> completeResult = new ArrayList<>();
           for ( int d = 1; d < actualValues.size(); d++ ) {
               List<String> secondList = new ArrayList<>();
               if ( d == 1) {
                   for (char c : actualValues.get(0).toCharArray()) {
                       completeResult.add(Character.toString(c));
                   }
               }
               for (char c : actualValues.get(d).toCharArray()) {
                   secondList.add(Character.toString(c));
               }

               completeResult = possibleCombinations(completeResult, secondList);
           }
           return completeResult;
        }
    }

    private static Map<Integer,String> getTelephoneMap() {
        Map<Integer, String> telephoneMap = new HashMap<>();
        telephoneMap.put(2, "abc");
        telephoneMap.put(3, "def");
        telephoneMap.put(4, "ghi");
        telephoneMap.put(5, "jkl");
        telephoneMap.put(6, "mno");
        telephoneMap.put(7, "pqrs");
        telephoneMap.put(8, "tuv");
        telephoneMap.put(9, "wxyz");
        return telephoneMap;
    }



    public static List<String> possibleCombinations(List<String> list1, List<String> list2) {
        List<String> comboList = new ArrayList<>();
        for(int i= 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(list1.get(i)).append(list2.get(j));
                comboList.add(sb.toString());
            }
        }
        return comboList;
    }
}

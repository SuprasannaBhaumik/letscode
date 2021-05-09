package com.learn.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flowrer","flower","flower"};
        System.out.println(LongestCommonPrefix.longestCommonPrefix(strs));
    }

    public LongestCommonPrefix() {
    }

    public static String longestCommonPrefix(String[] strs) {

        List<String> stringList = new ArrayList<String>(Arrays.asList(strs));

        //find the smallest string here
        String s = determineSmallestString(stringList);
        char[] smallestStringCharacters = s.toCharArray();
        Map<String, Integer> subStringMap = new HashMap<>();
        for(int i=smallestStringCharacters.length-1; i >= 0; i--) {
            String subString = s.substring(0, i+1);
            int noOfAppearances = stringList.stream().filter( element -> {
                return element.substring(0, subString.toCharArray().length).equals(subString);
            }).collect(Collectors.toList()).size();
            if(noOfAppearances == stringList.size()) {
                return subString;
            }
        }
        return "";
    }

    private static String determineSmallestString(List<String> stringList) {
        String shortest = stringList.get(0);
        for(String str : stringList) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        return shortest;
    }
}

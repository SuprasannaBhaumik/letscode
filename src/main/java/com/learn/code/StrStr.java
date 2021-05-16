package com.learn.code;

//https://leetcode.com/problems/implement-strstr/
public class StrStr {

    public static void main(String[] args) {
        System.out.println(StrStr.strStr("mississippi", "pi"));
    }

    public static int strStr(String haystack, String needle) {
        int result = 0;
        if(needle.equals("")) {
            return result;
        }
        if(haystack.contains(needle)) {
            int i = 0;
            int j = 0;
            char[] haystackArr = haystack.toCharArray();
            char[] needleArr = needle.toCharArray();
            int matchIndex = 0;
            int count = 0;
            boolean repeating = false;
            while(i < haystackArr.length && count < needleArr.length) {
                if (haystackArr[i] == needleArr[j]) {
                    matchIndex = i;
                    i++;
                    j++;
                    count++;
                    repeating = true;
                } else {
                    j = 0;
                    matchIndex = 0;
                    if(repeating) {
                        i -= count;
                        repeating = false;
                    }
                    count = 0;
                    i++;
                }
            }
            result = (matchIndex + 1 )- count;

        } else {
            result = -1;
        }

        return result;
    }
}

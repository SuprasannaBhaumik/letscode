package com.learn.code;

public class Palindrome_Number {

    public static void main(String[] args) {
        int x = -101;
        System.out.println(Palindrome_Number.isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        StringBuilder reverseString = new StringBuilder();
        reverseString.append(x);
        String intString = reverseString.toString();
        reverseString.reverse();
        String reverse = reverseString.toString();
        return intString.equals(reverse) ? true : false;
    }
}

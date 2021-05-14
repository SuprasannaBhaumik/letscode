package com.learn.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestValidParenthesis {

    public static void main(String[] args) {
        System.out.println(LongestValidParenthesis.longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {

        char[] strArr = s.toCharArray();
        Stack<Character> myStack = new Stack<Character>();
        int i = 0;
        List<Integer> longestValidParenthesis = new ArrayList<>();
        while(i < strArr.length) {
            if( i == strArr.length - 1 && myStack.size() == 0) {
                return 0;
            }
            int lastIndex = myStack.size()-1;
            if ( i == 0) {
                myStack.push(strArr[i]);
            } else {
                if (strArr[i] == ')') {
                    if (lastIndex != -1 && myStack.get(lastIndex) == '(') {
                        myStack.pop();
                    } else {
                        myStack.push(strArr[i]);
                    }
                } else {
                    myStack.push(strArr[i]);
                }
            }
           /* if(i !=0 && myStack.size() == 0) {
                if(longestValidParenthesis.size() != 0 && longestValidParenthesis.get(longestValidParenthesis.size() - 1) != null) {
                    longestValidParenthesis.add(i+1 - longestValidParenthesis.get(longestValidParenthesis.size() - 1));
                } else {
                    longestValidParenthesis.add(i+1);
                }
            } else if (i != 0 && myStack.size() == 1 && i == strArr.length -1) {
                if(longestValidParenthesis.size() !=0 && longestValidParenthesis.get(longestValidParenthesis.size() - 1) != null) {
                    longestValidParenthesis.add(i - longestValidParenthesis.get(longestValidParenthesis.size() - 1));
                } else {
                    longestValidParenthesis.add(i);
                }
            }*/


            i++;
        }
        return longestValidParenthesis.stream().mapToInt( o -> o).max().getAsInt();
    }
}

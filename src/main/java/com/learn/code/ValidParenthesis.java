package com.learn.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(ValidParenthesis.isValid("(){}}{"));
        //{(})}

    }

    public static boolean isValid(String s) {
        char[] strArr = s.toCharArray();
        Stack<Character> myStack = new Stack<Character>();
        int i = 0;
        while(i < strArr.length) {
            if( i == strArr.length - 1 && myStack.size() == 0) {
                return false;
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
                } else if (strArr[i] == '}') {
                    if (lastIndex != -1 && myStack.get(lastIndex) == '{') {
                        myStack.pop();
                    } else {
                        myStack.push(strArr[i]);
                    }
                } else if (strArr[i] == ']') {
                    if (lastIndex != -1 && myStack.get(lastIndex) == '[') {
                        myStack.pop();
                    } else {
                        myStack.push(strArr[i]);
                    }
                } else {
                    myStack.push(strArr[i]);
                }
            }
            i++;
        }
        return myStack.size() == 0;
    }
}

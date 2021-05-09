package com.learn.code;

public class Atoi {
    public static void main(String[] args) {
        String s = "21474836460";
        System.out.println(Atoi.myAtoi(s));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if(s.equals("")) {
            return 0;
        }
        boolean signExists = s.charAt(0) == '-' || s.charAt(0) == '+' ? true: false;
        boolean negativeSignExists = s.charAt(0) == '-' ? true : false;
        try {
            StringBuilder sb = new StringBuilder();
            if(signExists) {
                s = s.substring(1);
            }
            char[] brokenString = s.toCharArray();
            for (int i = 0; i < brokenString.length; i++) {
                String current = Character.toString(brokenString[i]);
                try {

                    int convertedString = Integer.parseInt(current);
                    sb.append(convertedString);
                } catch (NumberFormatException exception) {
                    if ( i == 0) {
                        return 0;
                    }
                    break;
                }
            }

            if (negativeSignExists) {
                return Integer.parseInt("-" + sb.toString());
            } else {
                return Integer.parseInt(sb.toString());
            }
        } catch (Exception e) {
            if (negativeSignExists) {
                return (int) Math.pow(-2, 31);
            } else {
                return (int) Math.pow(2, 31);
            }
        }
    }
}

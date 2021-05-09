package com.learn.code;

public class Palindrome_Max {

    public static void main(String s[]) {

        String inQuestion = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Palindrome_Max pm = new Palindrome_Max();
        System.out.println(pm.longestPalindrome(inQuestion));

    }

    public String longestPalindrome(String s) {
        char[] stringArray = s.toCharArray();

        if(stringArray.length == 1) {
            return s;
        } else if (stringArray.length == 2 && (stringArray[0] != stringArray[1])) {
            return s.substring(0, 1);
        }

        String resultantString = "";
        int count = 0;
        for (int i = 0; i < stringArray.length - 1; i++) {
            for (int y = i + 1; y < stringArray.length; y++) {
                String subString = s.substring(i, y) + Character.toString(stringArray[y]);
                resultantString = isPalindrome(subString, resultantString, count);
                count = resultantString.length();
            }
        }
        if("".equals(resultantString)) {
            return s.substring(0, 1);
        }
        return  resultantString;
    }

    public String isPalindrome(String s, String resultantString, int count) {

        char[] stringAsCharArray = s.toCharArray();
        boolean isPalindrome = true;

        int i = 0, j = stringAsCharArray.length - 1;

        int middle =
                stringAsCharArray.length % 2 == 0 ?
                        stringAsCharArray.length / 2 :
                        (stringAsCharArray.length - 1) / 2;
        while (isPalindrome && i < middle) {
            if (stringAsCharArray[i] == stringAsCharArray[j]) {
                i++;
                j--;
            } else {
                isPalindrome = false;
            }
        }

        if (isPalindrome) {
            if(stringAsCharArray.length > count) {
                resultantString = s;
            }
        }
        return resultantString;
    }

}

package com.learn.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(ZigZagConversion.convert("ABCDEFG", 2));
    }

    public static boolean calculateReverseLoop(int j, int rowCount) {
        boolean shouldContinue = true;
        boolean isReverse = false;
        if(j > rowCount) {
            while(shouldContinue && j > 0) {
                j = j - ((2 * rowCount) - 2);
                if(j > 0 && (j == rowCount) && j%rowCount == 0) {
                    shouldContinue = false;
                    isReverse = true;
                }
            }
        } else {
            return j % rowCount == 0;
        }

        return isReverse;
    }

    public static String convert(String s, int numRows) {

        if(numRows == 1) {
            return s;
        }

        Map<Integer, List<String>> indexMap = new HashMap<>();
        boolean roundCompleted = false;
        for(int j=0; j<s.toCharArray().length; j++) {
            if(j > s.toCharArray().length - 1) {
                break;
            }

            for(int i=0; i<numRows; i++) {

                if(roundCompleted && calculateReverseLoop(j, numRows) && numRows !=2 ) {
                    if(j > s.toCharArray().length - 1) {
                        break;
                    }
                    boolean forLoopExecuted = false;
                    for(int x = numRows-2; x > 0; x--) {
                        if(j > s.toCharArray().length - 1) {
                            break;
                        }
                        List <String> stringPositionList = indexMap.get(x);
                        stringPositionList.add(Character.toString(s.charAt(j)));
                        if(x != 1) {
                            j++;
                        }
                        forLoopExecuted = true;
                    }

                    if(!forLoopExecuted && j == numRows) {
                        List <String> stringPositionList = indexMap.get(0);
                        stringPositionList.add(Character.toString(s.charAt(j)));
                    }
                    break;
                }

                if(j > s.toCharArray().length -1) {
                    break;
                }

                if(indexMap.get(i) != null) {
                    List <String> stringPositionList = indexMap.get(i);
                    stringPositionList.add(Character.toString(s.charAt(j)));
                    indexMap.put(i, stringPositionList);
                } else {
                    List<String> stringList = new ArrayList<>();
                    stringList.add(Character.toString(s.charAt(j)));
                    indexMap.put(i, stringList);
                }
                if(i != numRows - 1) {
                    j++;
                }
                roundCompleted = true;
            }

        }

        StringBuilder sb = new StringBuilder();

        Iterator<Integer> it = indexMap.keySet().iterator();
        while(it.hasNext()) {
            Integer key = it.next();
            List<String> myList = indexMap.get(key);
            myList.forEach( value -> sb.append(value));
        }

        return sb.toString();
    }
}

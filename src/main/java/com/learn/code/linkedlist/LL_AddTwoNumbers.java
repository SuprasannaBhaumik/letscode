package com.learn.code.linkedlist;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LL_AddTwoNumbers {

    public LL_Node addTwoNumbers(LL_Node l1, LL_Node l2) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        do {
            list1.add(l1.getVal());
            l1 = l1.next;
        } while(l1 != null);

        do{
            list2.add(l2.getVal());
            l2 = l2.next;
        } while(l2 != null);


        Collections.reverse(list1);
        Collections.reverse(list2);
        StringBuffer sbfFirstNumber = new StringBuffer();
        StringBuffer sbfSecondNumber = new StringBuffer();
        for(int i=0;i<list1.size();i++){
            sbfFirstNumber.append(list1.get(i));
        }
        for(int i=0;i<list2.size();i++){
            sbfSecondNumber.append(list2.get(i));
        }

        BigInteger firstNumber = new BigInteger(sbfFirstNumber.toString());
        BigInteger secondNumber = new BigInteger(sbfSecondNumber.toString());

        BigInteger result = firstNumber.add(secondNumber);


        String number = String.valueOf(result);
        char[] digits = number.toCharArray();

        Map<Integer, LL_Node> nodeMap = new HashMap<>();

        LL_Node myNode = new LL_Node();

        for(int i = 0; i < digits.length; i++) {
            if( i == 0) {
                myNode.setVal(digits[i] - '0');
                myNode.setNext(null);
                nodeMap.put(i, myNode);
            } else {
                LL_Node thisNode = new LL_Node();
                thisNode.setVal(digits[i] - '0');
                thisNode.setNext(nodeMap.get(i-1));
                nodeMap.put(i, thisNode);
            }
        }
        return nodeMap.get(digits.length-1);
    }

}

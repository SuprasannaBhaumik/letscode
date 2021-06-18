
package com.learn.code.linkedlist;

public class LL_AddTwoNumbers_v1 {

    public static LL_Node addTwoNumbers(LL_Node l1, LL_Node l2, LL_Node result) {

        int sum = 0, tens = 0, units = 0;
        boolean flag = false;
        while (l1 != null || l2 != null) {

            if(result == null) {
                result = new LL_Node();
            } else {
                result.setNext(new LL_Node());
                flag = true;
            }
            int x = (l1 != null) ? l1.val : 0; // 9
            int y = (l2 != null) ? l2.val : 0; // 9
            sum = x + y + tens; //18
            if (sum >= 10) {
                tens = (sum % 100) / 10; // 1
                units = (sum % 10);      // 8
                if (flag) {
                    result.getNext().setVal(units);
                } else {
                    result.setVal(units);
                }
            } else {
                if(flag) {
                    result.getNext().setVal(result.getVal() + sum);
                } else {
                    result.val += sum;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return result;
    }

    public static void main(String s[]) {
        LL_Node ln = new LL_Node(3);
        LL_Node ln1 = new LL_Node(4,ln);
        LL_Node ln2 = new LL_Node(2,ln1);
        LL_Node ln_1 = new LL_Node(4);
        LL_Node ln_2 = new LL_Node(6,ln_1);
        LL_Node ln_3 = new LL_Node(5,ln_2);

        LL_Node result = null;
        result = LL_AddTwoNumbers_v1.addTwoNumbers(ln2,ln_3, result);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

}

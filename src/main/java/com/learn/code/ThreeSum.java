package com.learn.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(ThreeSum.threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answerList = new ArrayList<>();
        if(nums.length < 3) {
            return answerList;
        }
        for(int i=0; i< nums.length; i++) {
            if( i==8) {
                System.out.println("ha");
            }
            for (int j = i+1; j < nums.length; j++) {
                if( j==10) {
                    System.out.println("ha");
                }
                List<Integer> individualList = new ArrayList<>();
                int result = -(nums[i] + nums[j]);
                List<Integer> newList = createList(nums);
                newList.remove(newList.indexOf(nums[i]));
                newList.remove(newList.indexOf(nums[j]));
                if(newList.contains(result)) {
                    individualList.add(nums[i]);
                    individualList.add(nums[j]);
                    individualList.add(result);
                    if (answerList.size() == 0 || !checkIfEntriesExist(individualList, answerList)) {
                        System.out.println("added this list now ");

                        answerList.add(individualList);
                    }
                }
            }
        }
        return answerList;
    }

    private static List<Integer> createList(int[] nums) {
        List<Integer> myList = new ArrayList<>(nums.length);
        for (int i : nums){
            myList.add(i);
        }
        return myList;
    }

    private static boolean checkIfEntriesExist(List<Integer> individualList, List<List<Integer>> answerList) {
        System.out.println("-----------start of method -----------");
        /*AtomicBoolean flag = new AtomicBoolean(true);
        answerList.forEach( specificList -> {
            for (int num: individualList) {
                if(specificList.contains(num)) {
                    specificList.remove(specificList.indexOf(num));
                }
            }
            if(specificList.size() == 0) {
                flag.set(flag.get() && false);
            }
        });
        return flag.get();*/

        /*AtomicBoolean flag = new AtomicBoolean(true);
        answerList.forEach( specificList -> {
            for (int num: individualList) {
                flag.set(flag.get() && specificList.contains(num));
            }
        });*/

        //answer list is complete set
        //specificList -> part of answer list
        //individualList -> what we need to compare
        for(int i=0; i<answerList.size(); i++) {
            List<Integer> specificList = new ArrayList<>(answerList.get(i));
            for (int number: specificList) {
                System.out.println(number);
            }
            System.out.println("=================");
            boolean match = true;
            for(int j=0; j< individualList.size(); j++) {
                System.out.println("Individual element ->" + individualList.get(j));
                System.out.println("does specificlist contain our element already -> " + specificList.contains(individualList.get(j)));
                match = match && specificList.contains(individualList.get(j));
                if(specificList.contains(individualList.get(j))) {
                    specificList.remove(specificList.indexOf(individualList.get(j)));
                }
                System.out.println("current match ->" + match);
            }
            System.out.println("overall match ->" + match);
            if(match) {
                return true;
            }

        }
        System.out.println("-----------end of method -----------" + false);
        return false;
    }
}

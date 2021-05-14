package com.learn.code;

import java.util.ArrayList;
import java.util.List;

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
            for (int j = i+1; j < nums.length; j++) {
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
        for(int i=0; i<answerList.size(); i++) {
            List<Integer> specificList = new ArrayList<>(answerList.get(i));
            boolean match = true;
            for(int j=0; j< individualList.size(); j++) {
                match = match && specificList.contains(individualList.get(j));
                if(specificList.contains(individualList.get(j))) {
                    specificList.remove(specificList.indexOf(individualList.get(j)));
                }
            }
            if(match) {
                return true;
            }
        }
        return false;
    }
}

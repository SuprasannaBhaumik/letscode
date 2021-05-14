package com.learn.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array nums of n integers,
 * return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 */
public class FourSum {

    public static void main(String[] args) {

        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(FourSum.fourSum_Poornima(nums, 9));
    }

    public static List<List<Integer>> fourSum_Poornima(int[] nums, int target) {
        Set<List<Integer>> num = new HashSet<>();
        Arrays.sort(nums);

        for ( int numner: nums) {
            System.out.print(numner + ",");
        }

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int second = j + 1;
                int last = nums.length - 1;
                while (second < last) {
                    if (nums[i] + nums[j] + nums[second] + nums[last] == target) {
                        num.add(Arrays.asList(nums[i], nums[j], nums[second], nums[last]));
                        second++;
                        last--;
                    } else if (nums[i] + nums[j] + nums[last] + nums[second] < target) {
                        second++;
                    } else {
                        last --;
                    }
                }
            }
        }
        return new ArrayList<>(num);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answerList = new ArrayList<>();
        if(nums.length < 4) {
            return answerList;
        }
        for(int i=0; i< nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> individualList = new ArrayList<>();
                    int result = target - (nums[i] + nums[j] + nums[k]);
                    List<Integer> newList = createList(nums);
                    newList.remove(newList.indexOf(nums[i]));
                    newList.remove(newList.indexOf(nums[j]));
                    newList.remove(newList.indexOf(nums[k]));
                    if(newList.contains(result)) {
                        individualList.add(nums[i]);
                        individualList.add(nums[j]);
                        individualList.add(nums[k]);
                        individualList.add(result);
                        if (answerList.size() == 0 || !checkIfEntriesExist(individualList, answerList)) {
                            answerList.add(individualList);
                        }
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

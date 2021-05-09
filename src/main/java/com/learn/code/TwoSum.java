package com.learn.code;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        //constraint 1
        if(nums.length >= 2 && nums.length <= 1000 ) {
            int[] results = new int[]{};
            //Condition 1 : run with one another
            List<Integer> integerList = null;
            for(int i=0; i < nums.length; i++) {
                integerList = new ArrayList<>();
                integerList.add(i);
                for(int j = 0; j < nums.length; j++) {
                    if(i != j) {
                        if (nums[i] + nums[j] != target) {
                            continue;
                        } else {
                            integerList.add(j);
                            return getResultsArray(results, integerList);
                        }
                    }
                }
            }
        }
        return null;
    }

    private int[] getResultsArray(int[] results, List<Integer> integerList) {
        /*for(int x = 0; x < integerList.size(); x++) {
            System.out.println(integerList.get(x));
        }*/
        return integerList.stream().mapToInt(i -> i).toArray();
    }
}

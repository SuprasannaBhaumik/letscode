package com.learn.code.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(ContainsDuplicate.containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {

        boolean result = false;
        Map<Integer, Integer> valueMap = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if(i==0) {
                valueMap.put(nums[i], 1);
            } else {
                if(valueMap.containsKey(nums[i])) {
                    int value = valueMap.get(nums[i]);
                    if(value == 1) {
                        result = true;
                        break;
                    }
                    valueMap.put(nums[i], valueMap.get(nums[i])+1);
                } else {
                    valueMap.put(nums[i], 1);
                }
            }
        }
        return result;
    }

}

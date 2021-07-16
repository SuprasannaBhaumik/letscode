package com.learn.code.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllDuplicates {

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(AllDuplicates.findDuplicates(nums));
    }

    public static int[] findDuplicates(int[] nums) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int i=0; i< nums.length; i++) {
            if(i==0) {
                valueMap.put(nums[i], 1);
            } else {
                if(valueMap.containsKey(nums[i])) {
                    int value = valueMap.get(nums[i]);
                    valueMap.put(nums[i], value+1);
                    uniqueNumbers.add(nums[i]);
                } else {
                    valueMap.put(nums[i], 1);
                }
            }
        }
        int[] result = new int[uniqueNumbers.size()];
        int i = 0;
        for(Integer x: uniqueNumbers) {
            result[i++] = x;
        }
        return result;
    }
}

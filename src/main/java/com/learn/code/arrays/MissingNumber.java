package com.learn.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {

    public static void main(String[] args) {

        int nums[] = {1, 2, 0, 4};
        System.out.println(MissingNumber.missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        return -1;

        /*int result = 0;
        List<Integer> integerList = new ArrayList<>();
        for(int i: nums) {
            integerList.add(i);
        }
        for(int i=1; i<=nums.length; i++) {
            if(!integerList.contains(i)) {
                result = i;
                break;
            }
        }
        return result;*/
    }

}

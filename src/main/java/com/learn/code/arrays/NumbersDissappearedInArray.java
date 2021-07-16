package com.learn.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersDissappearedInArray {

    public static void main(String[] args) {

        int nums[] = {1,1};
        System.out.println(NumbersDissappearedInArray.findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        /*List<Integer> integerList = new ArrayList<>();
        for(int i: nums) {
            integerList.add(i);
        }
        for(int i=1; i<=nums.length; i++) {
            if(!integerList.contains(i)) {
                result.add(i);
            }
        }
        return result;*/

        Arrays.sort(nums);

        while(nums.length > 0) {
            if(nums[0] != 1) {
                result.add(1);
                nums = Arrays.copyOfRange(nums, 1, nums.length-1);
            } else if (nums[nums.length-1] != nums.length) {
                result.add(nums.length);
                nums = Arrays.copyOfRange(nums, 0, nums.length-2);
            }
        }
        return result;
    }
}

package com.learn.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClosestNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,3,7,9,10};
        int target = 13;
        System.out.println(ClosestNumber.findClosest(nums, target));
    }

    private static int findClosest(int[] nums, int target) {
        int result = 0;
        Map<Integer, Integer> targetMap = new HashMap<>();

        int count = 0;
        while(count < nums.length) {
            if(target == nums[count]) {
                return target;
            }
            targetMap.put(nums[count], target > nums[count] ? target - nums[count] : nums[count] - target);
            count++;
        }

        List<Integer> valueList =
                targetMap
                        .values()
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());

        if(valueList.size() > 0) {
            int targetValue = valueList.get(0);



            return target + targetValue;
        }
        return result;
    }
}

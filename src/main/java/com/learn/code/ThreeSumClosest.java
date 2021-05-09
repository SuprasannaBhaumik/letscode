package com.learn.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int target = 100;
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(ThreeSumClosest.threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {

        List<Integer> myResultsSet = new ArrayList<>();

        for(int i=0; i < nums.length; i ++) {
            for (int j = i+1; j<nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    myResultsSet.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        List<Integer> results = myResultsSet.stream().distinct().collect(Collectors.toList());
        Collections.sort(results);
        int closest = closest(target, results);
        return closest;
    }

    public static int closest(int target, List<Integer> in) {
        int min = Integer.MAX_VALUE;
        int closest = target;

        for (int v : in) {
            final int diff = Math.abs(v - target);

            if (diff < min) {
                min = diff;
                closest = v;
            }
        }
        return closest;
    }


}

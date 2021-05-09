package com.learn.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Median_TwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedian(mergeSortedArray(nums1, nums2));
    }


    public int[] mergeSortedArray_Core(int[] nums1, int[] nums2) {
        int lengthNums1 = 0, lengthNums2 = 0;
        if (nums1 != null) {
            lengthNums1 = nums1.length;
        }

        if (nums2 != null) {
            lengthNums2 = nums2.length;
        }
        int size = lengthNums1 + lengthNums2;

        int[] result = new int[size];

        //need to perform bubble sort: O(n^2)
       /* for(int i = 0; i < size - 1; i++) {
            for( int j = i + 1; j < size -1 ; j++) {
                nums1[i]
            }
       }*/


        return null;
    }

    public int[] mergeSortedArray(int[] nums1, int[] nums2) {

        List<Integer> numbersArray = new ArrayList<>();

        for (int i : nums1) {
            numbersArray.add(i);
        }
        for (int j : nums2) {
            numbersArray.add(j);
        }

        Collections.sort(numbersArray);

        int[] resultArray = new int[numbersArray.size()];
        for (int x = 0; x < numbersArray.size(); x++) {
            resultArray[x] = numbersArray.get(x);
        }
        return resultArray;
    }

    public double findMedian(int nums[]) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length % 2 == 0) {
            int middleIndex = nums.length / 2;
            return (double) (nums[middleIndex] + nums[middleIndex - 1]) / 2;
        } else {
            return nums[(nums.length - 1) / 2];
        }
    }

    public static void main(String sp[]) {
        Median_TwoSortedArray b = new Median_TwoSortedArray();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        System.out.println(b.findMedianSortedArrays(nums1, nums2));

    }

}

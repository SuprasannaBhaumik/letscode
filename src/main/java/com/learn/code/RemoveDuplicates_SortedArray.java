package com.learn.code;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates_SortedArray {


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 1, 2, 1, 1, 0};
        System.out.println(RemoveDuplicates_SortedArray.removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int decrementSize = 0;
        for (int i = 0; i < nums.length - decrementSize; i++) {
            for( int j = i+1; j < nums.length - decrementSize; j++) {
                boolean repeat = false;
                if(nums[i] == nums[j]) {
                    for(int k = j; k < nums.length - decrementSize; k++) {
                        if( k != nums.length - 1) {
                            int temp = nums[k];
                            nums[k] = nums[k+1];
                            nums[k+1] = temp;
                            if(nums[k] == nums[k+1]) {
                                repeat = true;
                            }
                        }
                    }
                    decrementSize++;
                }
                if(repeat) {
                    j--;
                }
            }
        }
        return nums.length - decrementSize;
    }

}

package com.learn.code;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(RemoveElement.removeElement( nums, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;

        if(nums.length == 1 && nums[0] == val) {
            return 0;
        }
        for ( int k = nums.length - 1; k >= 0; k-- ) {
            if( nums[k] == val) {
                count++;
            }
        }

        if(count == nums.length) {
            return 0;
        }

        int i = 0;
        int endPoint = 1;
        while( i < nums.length - endPoint) {
            boolean repeat = false;
            if(nums[i] == val) {
                if(i != nums.length - 1 && nums[i] == nums[i+1]) {
                    repeat = true;
                }
                for(int j = i; j < nums.length - endPoint; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
                endPoint++;
            }

            if(repeat) {
                i--;
            }
            i++;
        }

        return nums.length - count;
    }
}

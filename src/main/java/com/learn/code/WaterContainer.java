package com.learn.code;

public class WaterContainer {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxWater = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j=0; j < height.length; j++) {
                int waterAmount = Math.min(height[i], height[j]) * (j-i);
                if (waterAmount > maxWater) {
                    maxWater = waterAmount;
                }
            }
        }
        return maxWater;
    }
}

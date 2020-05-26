package com.yi.interviewquestions.Random;

public class TrappingRainWater {
    public int trap(int[] height) {
        int leftMax = 0; int rightMax = height.length-1;
        int left = 0; int right = height.length-1;
        int result = 0;

        while(left < right){
            if(height[left] < height[right]){
                if (height[left] >= height[leftMax]) {
                    leftMax = left;
                } else {
                    result += (height[leftMax] - height[left]);
                }
                left++;
            }else{
                if (height[right] >= height[rightMax]) {
                    rightMax = right;
                } else {
                    result += height[rightMax] - height[right];
                }
                right--;
            }
        }

        return result;
    }
}

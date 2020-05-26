package com.yi.interviewquestions.ByteDance;

public class TrapWater {
    public int trap(int[] height) {
        int left = 0; int right = height.length-1;
        int leftMax = 0; int rightMax = height.length-1;
        int result = 0;

        while(left < right){
            if(height[left] < height[right]){
                if (height[leftMax] <= height[left]) {
                    leftMax = left;
                } else {
                    result += height[leftMax] - height[left];
                }
                left++;
            }else{
                if (height[rightMax] <= height[right]) {
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

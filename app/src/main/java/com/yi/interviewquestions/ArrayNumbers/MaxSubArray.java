package com.yi.interviewquestions.ArrayNumbers;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // write your code here
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;

        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum-minSum);
            minSum = Math.min(sum,minSum);
        }

        return max;

    }
}

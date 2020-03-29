package com.yi.interviewquestions.Airbnb;

import java.util.Arrays;
import java.util.List;

public class MaximumNumofNightsYouCanAccommodate {

    int[] dp;
    public int rob(int[] nums) {

        dp = new int[nums.length+2];
        for(int i = 0; i< dp.length; i++){
            dp[i] = -1;
        }

        int sum = findSum(nums,0);

        return sum;
    }

    public int findSum(int[] nums, int start){

        if(start >= nums.length) return 0;
        int sum = 0;
        int Max = 0;
        for(int i = start; i< nums.length; i++){
            sum = nums[i];
            if(i+2 < nums.length && dp[i+2]!=-1){
                sum += dp[i+2];
            }else {
                dp[i+2] = findSum(nums, i + 2);
                sum += dp[i+2];
            }
            Max = Math.max(sum,Max);
        }

        return Max;
    }

}

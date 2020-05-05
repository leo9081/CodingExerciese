package com.yi.interviewquestions.Facebook;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == k) count++;
            int target = k - nums[i];
            count += findRest(nums, i+1, target);
        }

        return count;

    }

    public int findRest(int[] nums, int start, int target){

        int sum = 0;
        int count = 0;
        for(int i = start; i < nums.length; i++){
            sum += nums[i];
            if(sum == target) count++;
        }

        return count;
    }
}

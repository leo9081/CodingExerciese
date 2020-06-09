package com.yi.interviewquestions.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        Arrays.sort(nums);

        for(int i = 0 ; i< nums.length; i++){
            int target = 0 - nums[i];
            if(i > 0 && nums[i] == nums[i-1]) continue;
            twoSum(nums,i,result, target);
        }

        return result;
    }

    public void twoSum(int[] nums, int start, List<List<Integer>> result, int target){
        int s = start+1 ; int end = nums.length -1;

        while(s < end){
            if(nums[s] + nums[end] == target){
                List<Integer> t = new ArrayList<>();
                t.add(nums[start]);t.add(nums[s]);t.add(nums[end]);
                result.add(t);
                s++;end--;
                while(s < end && nums[s] == nums[s-1])s++;
                while(end > s && nums[end] == nums[end+1])end--;

            }else if(nums[s] + nums[end] > target){
                end--;
            }else if(nums[s] + nums[end] < target){
                s++;
            }
        }

        return;
    }
}

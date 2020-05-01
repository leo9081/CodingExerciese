package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    HashMap<Integer,Integer> h = new HashMap<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i< nums.length; i++){
            h.put(nums[i],i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i< nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            twoSum(nums,target,result,i+1);
        }
        return result;
    }

    public void twoSum(int[] nums, int target, List<List<Integer>> result, int start){

        for(int i = start; i< nums.length-1; i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            int t = target - nums[i];
            if(h.containsKey(t) && h.get(t)>i){
                List<Integer> sr = new ArrayList<>();
                sr.add(0-target);
                sr.add(nums[i]);
                sr.add(t);
                result.add(sr);
            }
        }
    }
}

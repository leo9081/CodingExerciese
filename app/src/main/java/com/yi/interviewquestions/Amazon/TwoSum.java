package com.yi.interviewquestions.Amazon;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0) return result;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++){
            hm.put(nums[i],i);
        }

        for(int i = 0 ; i < nums.length; i++){
            int subt = target - nums[i];
            if(hm.containsKey(subt) && hm.get(subt)!=i){
                result[0] = i;
                result[1] = hm.get(subt);
                return result;
            }
        }

        return result;
    }
}

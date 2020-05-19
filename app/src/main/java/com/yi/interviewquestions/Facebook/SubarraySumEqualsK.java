package com.yi.interviewquestions.Facebook;

import java.util.HashMap;

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

    public int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap< >();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

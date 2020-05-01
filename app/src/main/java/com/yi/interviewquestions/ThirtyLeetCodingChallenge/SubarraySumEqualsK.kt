package com.yi.interviewquestions.ThirtyLeetCodingChallenge

class SubarraySumEqualsK {

    fun subarraySum(nums: IntArray, k: Int): Int {
        var f = Array(nums.size, {IntArray(nums.size)});

        var count = 0;

        for(i in nums.indices){
            var total = nums[i];
            if(nums[i] == k){
                count++;
                continue;
            }
            for(j in i+1 until nums.size){
                if(nums[j] == k || nums[j] == k - total){
                    count++;
                }else{
                    total += nums[j];
                }
            }

        }
        return count;
    }


}
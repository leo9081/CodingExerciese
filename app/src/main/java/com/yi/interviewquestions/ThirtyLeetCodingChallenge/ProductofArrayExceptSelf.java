package com.yi.interviewquestions.ThirtyLeetCodingChallenge;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int all = 1;
        int appearCounts = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0){
                appearCounts++;
                continue;
            }
            all *= nums[i];
        }

        int[] result = new int[nums.length];
        if(appearCounts>1) return result;
        for(int i = 0; i< nums.length; i++){
            if(appearCounts == 1){
                if(nums[i] == 0) result[i] = all;
                else result[i] = 0;
            }else{
                result[i] = all/nums[i];
            }
        }


        return result;
    }
}

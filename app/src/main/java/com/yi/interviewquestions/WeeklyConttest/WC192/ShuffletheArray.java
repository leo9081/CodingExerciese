package com.yi.interviewquestions.WeeklyConttest.WC192;

public class ShuffletheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int i = 0; int j = n;
        int c = 0;
        while(i < n && j < nums.length){
            if(c % 2 == 0){
                result[c] = nums[i];
                i++;
            }else{
                result[c] = nums[j];
                j++;
            }
            c++;
        }

        while(i < n){
            result[c] = nums[i];
            i++;
            c++;
        }

        while(j < nums.length){
            result[c] = nums[j];
            j++;
            c++;
        }
        return result;
    }
}

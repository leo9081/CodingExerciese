package com.yi.interviewquestions.Facebook;

public class NextPermutation {
    public void nextPermutation(int[] nums) {

        //find first decent integer from end
        //find first integer larger then integer
        //swap two integer, break

        //reverse the i+1 till end

        int i = nums.length -2;

        while(i>=0){
            if(nums[i] < nums[i+1]){
                int j = nums.length -1;
                while(nums[j] <= nums[i]) j--;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }
            i--;
        }
        reverse(nums, i+1);
        return;
    }

    public void reverse(int[] nums, int pos){
        int l = nums.length-1;
        while(pos < l){
            int temp = nums[pos];
            nums[pos] = nums[l];
            nums[l] = temp;
            l--; pos++;
        }
    }
}

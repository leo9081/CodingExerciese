package com.yi.interviewquestions.Facebook;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //calculate all the product, when needed devide by nums[i]
        //if one 0, create two result, one with 0, one without.
        //if more 0, return all 0;
        int[] result = new int[nums.length];

        int zeroCount = 0;
        int pos = 0;
        int product = 1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0) {
                if(zeroCount==1) return result;
                else{
                    pos= i;
                    zeroCount++;
                }
            }else{
                product *= nums[i];
            }
        }

        if(zeroCount==1){
            result[pos] = product;
            return result;
        }

        for(int i = 0; i< nums.length; i++){
            result[i] = product/nums[i];
        }

        return result;
    }


    //Solution Leetcode: o(1) space. 1 ms faster
    class Solution {
        public int[] productExceptSelf(int[] nums) {

            // The length of the input array
            int length = nums.length;

            // Final answer array to be returned
            int[] answer = new int[length];

            // answer[i] contains the product of all the elements to the left
            // Note: for the element at index '0', there are no elements to the left,
            // so the answer[0] would be 1
            answer[0] = 1;
            for (int i = 1; i < length; i++) {

                // answer[i - 1] already contains the product of elements to the left of 'i - 1'
                // Simply multiplying it with nums[i - 1] would give the product of all
                // elements to the left of index 'i'
                answer[i] = nums[i - 1] * answer[i - 1];
            }

            // R contains the product of all the elements to the right
            // Note: for the element at index 'length - 1', there are no elements to the right,
            // so the R would be 1
            int R = 1;
            for (int i = length - 1; i >= 0; i--) {

                // For the index 'i', R would contain the
                // product of all elements to the right. We update R accordingly
                answer[i] = answer[i] * R;
                R *= nums[i];
            }

            return answer;
        }
    }

}

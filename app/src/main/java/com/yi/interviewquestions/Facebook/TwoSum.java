package com.yi.interviewquestions.Facebook;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    //Two pointer solution.
    //if the answer needs index, than this solution is not efficient
    //IT WILL NOT WORK IF duplicate APPEAR IN  THE INPUT LIST
    public int[] twoSum3(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] result = new int[2];


        HashMap<Integer,Integer> h = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            h.put(nums[i],i);
        }
        Arrays.sort(nums);

        int i = 0; int j = nums.length-1;
        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                result[0]= h.get(nums[i]);
                result[1] = h.get(nums[j]);
                return result;
            }else if(sum > target) j--;
            else i++;
        }

        return result;
    }

    //if the answer is the number
    public int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] result = new int[2];

        Arrays.sort(nums);

        int i = 0; int j = nums.length-1;
        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                result[0]= nums[i];
                result[1] = nums[j];
                return result;
            }else if(sum > target) j--;
            else i++;
        }

        return result;
    }


    //HashMap solution
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] result = new int[2];

        HashMap<Integer,Integer> h = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            h.put(nums[i],i);
        }

        for(int i = 0; i < nums.length-1;i++){
            int num = target - nums[i];
            if(h.containsKey(num) && i != h.get(num)){
                result[0] = i;
                result[1] = h.get(num);
                break;
            }
        }

        return result;
    }



}

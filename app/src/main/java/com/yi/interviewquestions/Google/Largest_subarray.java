package com.yi.interviewquestions.Google;

import java.util.Arrays;

public class Largest_subarray {

/*    public int[] Solution(int[] input, int k){
        int[] result = new int[k];
        if(input == null || input.length == 0) return result;

        int start = 0;
        for(int end = k; end<= input.length; end++){
            int[] temp = Arrays.copyOfRange(input,start,end);
            if(result.length == 0){
                result = temp;
            }else{
                result = compareTwoArrays(result, temp);
            }
            start++;
        }

        return result;
    }

    public int[] compareTwoArrays(int[] a, int[] b){
        for(int i = 0; i< a.length; i++){
            if(a[i] > b[i]){
                return a;
            }else return b;
        }
        return a;
    }*/

    public int[] Solution(int[] input, int k){
        int start = 0;
        for(int i = 1; i <= input.length - k; i++){
            if(input[i] > input[start]){
                start = i;
            }
        }
        return Arrays.copyOfRange(input,start,start+k);
    }

    public static void main(String[] args){
        Largest_subarray ls = new Largest_subarray();
        //int[] input = {1,4,3,2,5};
        int[] input = {5,6,4,1,3};
        int K = 3;
        int[] result = ls.Solution(input,K);
        for(int i: result){
            System.out.println(i);
        }
    }
}

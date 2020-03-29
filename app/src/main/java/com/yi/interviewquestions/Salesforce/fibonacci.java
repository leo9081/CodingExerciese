package com.yi.interviewquestions.Salesforce;

public class fibonacci {

    public int sumoffibonacci(int k){
        int[] dp = new int[k+3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i  = 3; i< k ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[k-1];
    }

    public static void main(String[] args){
        fibonacci f = new fibonacci();
        System.out.println(f.sumoffibonacci(1));
    }
}

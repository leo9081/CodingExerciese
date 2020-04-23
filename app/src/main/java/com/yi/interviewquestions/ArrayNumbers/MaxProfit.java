package com.yi.interviewquestions.ArrayNumbers;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        // write your code here

        int[] diff = new int[prices.length-1];
        for(int i = 1; i < prices.length; i++){
            diff[i-1] = prices[i] - prices[i-1];
        }
        int result = maxSub(diff);
        if(result<=0) return 0;
        return result;
    }

    public int maxSub(int[] diff) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;

        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
        }

        return max;
    }
}

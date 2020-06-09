package com.yi.interviewquestions.Amazon;

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int start = prices[0];
        int total = 0;

        for(int i = 1 ; i< prices.length; i++){
            if(prices[i] > start){
                total = Math.max(total, prices[i] - start);
            }else{
                start = prices[i];
            }
        }

        return total;
    }

    public int maxProfit2(int[] prices) {
        //[0, -6, 4, -2,3,-2]
        //[0,-6, -2, -4, -1, -3]
        //f[i][j] = max(max,sum[j] - sum[i]);
        if (prices == null || prices.length == 0) return 0;

        int[] sum = new int[prices.length];
        sum[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            sum[i] = sum[i - 1] + prices[i] - prices[i - 1];
        }

        int[] f = new int[prices.length];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j < i; j++) {

                f[i] = Math.max(f[i], sum[i] - sum[j]);
                f[i] = Math.max(f[i], f[i - 1]);
            }
        }

        return f[prices.length - 1];

    }
}

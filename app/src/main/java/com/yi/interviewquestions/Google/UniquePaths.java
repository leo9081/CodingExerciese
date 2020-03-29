package com.yi.interviewquestions.Google;

public class UniquePaths {

    public int question1(int m, int n){

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int j = 0; j<n; j++){
            for(int i = 0;i<m;i++){
                if(j>0) {
                    dp[i][j] += dp[i][j - 1];
                    if (i > 0) dp[i][j] += dp[i - 1][j - 1];
                    if (i < m - 1) dp[i][j] += dp[i + 1][j - 1];
                }else{
                    if(i>0) dp[i][j] = 0;
                }
            }
        }
        return dp[0][n-1];
    }

    public int question2(int m, int n, int p1x, int p1y, int p2x, int p2y, int p3x, int p3y){
        int resutl1 = helper(p1x,p1y,0,0);
        int resutl2 = helper(p2x,p2y,p1x,p1y);
        int resutl3 = helper(p3x,p3y,p2x,p2y);
        int resutl4 = helper(m,n,p3x,p3y);

        int result = resutl1+resutl2+resutl3;

        return result;

    }

    public int helper(int m, int n, int startx, int starty){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int j = starty; j<n; j++){
            for(int i = startx;i<m;i++){
                if(j>starty) {
                    dp[i][j] += dp[i][j - 1];
                    if (i > startx) dp[i][j] += dp[i - 1][j - 1];
                    if (i < m - 1) dp[i][j] += dp[i + 1][j - 1];
                }else{
                    if(i>startx) dp[i][j] = 0;
                }
            }
        }
        return dp[0][n-1];
    }


}

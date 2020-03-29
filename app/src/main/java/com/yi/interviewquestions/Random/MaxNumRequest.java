package com.yi.interviewquestions.Random;

public class MaxNumRequest {
    /*
    [[6,100],[4,26],[20,25],[40,64]]
        94    22      5     24
        output 3
          4 25 26 64

          2 23 4 40

          dp[i][j] 在i-j的点内，最高可以有多少分
          dp[i][j] = isOK && dp[i][j-1] + point[i][j];

       [2,4][4,5][20,25][40,64]
        2     1     5     24

        4 5 25 64
        1
     */

}

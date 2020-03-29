package com.yi.interviewquestions.DP;

public class PalindromePartitioning {

    public int minCut(String s) {
        // write your code here
        int m = s.length();

        int[] f = new int[m+1];

        for(int i = 0; i<= m; i++){
            f[i] = Integer.MAX_VALUE;
        }

        boolean[][] PalindromeArray = isPalindrome(s);

        f[0] = 0;

        for(int i = 1; i<= m; i++) {
            for(int j = 0; j< i ;j++) {
                if (PalindromeArray[j][i-1]) {
                    f[i] = Math.min(f[i], f[j] + 1);

                }
            }
        }


        return f[m]-1;
    }


    public boolean[][] isPalindrome(String s){
        int l = s.length();

        boolean[][] f = new boolean[l][l];

        for(int i = 0; i< l; i++){
            f[i][i] = true;
        }

        for (int m = 0; m < s.length() - 1; m++) {
            f[m][m + 1] = (s.charAt(m) == s.charAt(m + 1));
        }

        for(int i = 2; i< l; i++){
            for(int j = 0 ; j+1<=i-1; j++){
                f[j][i] = f[j+1][i-1] && s.charAt(i) == s.charAt(j);
            }
        }



        return f;
    }

}

package com.yi.interviewquestions.Amazon;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        boolean[][] f = new boolean[s.length()][s.length()];
        f[0][0] = true;
        String result = "";
        int max = 0;

        for(int i = 1; i < s.length(); i++){
            f[i][i] = true;
            f[i-1][i] = s.charAt(i-1) == s.charAt(i);
            if(f[i-1][i]){
                max = 2;
                result = s.substring(i-1,i+1);
            }
        }

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j<i-1; j++){
                f[j][i] = f[j][i] || f[j+1][i-1] && (s.charAt(j) == s.charAt(i));
                if(f[j][i] && i-j+1 > max){
                    max = i-j+1;
                    result = s.substring(j,i+1);
                }
            }
        }
        return result != ""? result:s.substring(0,1);
    }
}

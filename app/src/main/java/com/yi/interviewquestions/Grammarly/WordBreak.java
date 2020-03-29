package com.yi.interviewquestions.Grammarly;

import java.util.List;
import java.util.Set;

public class WordBreak {

    public int minWordBreak(String s, Set<String> dict){

        int[] dp = new int[s.length()+1];

        dp[0] = 1;


        for(int i = 1 ; i <= s.length(); i++){
            int min = Integer.MAX_VALUE;

            for(int j = 0; j< i; j++){
                if(dict.contains(s.substring(j, i)) && dp[j] > 0) {
                    if (dp[j] < min) {
                        dp[i] = dp[j] + 1;
                        min = dp[j];
                    }

                }
            }
        }


        return dp[s.length()]-1;

    }

}

package com.yi.interviewquestions.DP;

import java.util.Set;

public class WordBreak {


    public boolean wordBreak(String s, Set<String> dict){

        int m = s.length();

        boolean[] f = new boolean[m+1];

        f[0] =true;

        for(int i = 1; i<= m; i++) {
           for(int j = 0; j< i; j++) {
               f[i] = f[i] || (f[j] && isWord(s.substring(j , i), dict));
           }
        }

        return f[m];
    }


    public boolean wordBreakImprove(String s, Set<String> dict){

        int m = s.length();

        boolean[] f = new boolean[m+1];

        f[0] =true;

        int maxLength = findMaxLength(dict);

        for(int i = 1; i<= m; i++) {
            f[i] = false;
            for(int j = 1; j <= maxLength && j<=i; j++) {
                if(!f[i - j]) continue;
                f[i] = f[i] || (f[i-j] && isWord(s.substring(i-j , i), dict));
            }
        }

        return f[m];
    }

    public boolean isWord(String word, Set<String> dict){
        return dict.contains(word);
    }

    public int findMaxLength(Set<String> dict){
        int max = Integer.MIN_VALUE;
        for(String word: dict){
            max = Math.max(max,word.length());
        }

        return max;
    }
}

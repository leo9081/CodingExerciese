package com.yi.interviewquestions.Amazon;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> hs = new HashSet<String>(wordDict);
        boolean[] f = new boolean[s.length()+1];

        f[0] = true;

        for(int j = 1 ; j <= s.length(); j++){
            for(int i = 0; i<j; i++){
                f[j] = f[j] || (f[i] && hs.contains(s.substring(i,j)));
            }
        }

        return f[s.length()];
    }
}

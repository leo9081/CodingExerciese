package com.yi.interviewquestions.Facebook;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //f[i] till i can successfully cut to a word
        //j if j-i is in dic && f[i] f[j] true;
        //f[j] = f[j] || f[i] && worDict.contains(s.subString(j,i))

        boolean[] f = new boolean[s.length()+1];

        f[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j<i; j++){
                f[i] = f[i] || (f[j] && wordDict.contains(s.substring(j,i)));
            }
        }

        return f[s.length()];
    }
}

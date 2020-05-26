package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    // time out
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);

        // Check if there is at least one possible sentence
        boolean[] dp1 = new boolean[s.length() + 1];
        dp1[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp1[i] = dp1[i] || (dp1[j] && wordSet.contains(s.substring(j, i)));
            }
        }

        // We are done if there isn't a valid sentence at all
        if (!dp1[s.length()]) {
            return new ArrayList<String>();
        }

        List<String>[] f = new ArrayList[s.length() + 1];

        List<String> inital = new ArrayList<String>();
        inital.add("");
        f[0] = inital;

        for(int i = 1; i <= s.length(); i++){
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < i; j++){
                if(f[j].size() > 0 && wordDict.contains(s.substring(j,i))){
                    for(String k: f[j]){
                        temp.add(k+ (k.equals("") ? "" : " ")+s.substring(j,i));
                    }
                }
            }
            f[i] = temp;
        }


        return f[s.length()];
    }
}

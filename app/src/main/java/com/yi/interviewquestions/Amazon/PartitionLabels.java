package com.yi.interviewquestions.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

    //greedy
    public List<Integer> partitionLabels2(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    //search by each character's last pos
    //update the pos if find bigger one.
    //time Complexity: n^2
    //space complexity: n
    public List<Integer> partitionLabels(String S) {

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            hm.put(S.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < S.length(); i++){
            int lastPos = fixPos(i,hm,S,i);
            result.add(lastPos-i+1);
            i = lastPos;
        }

        return result;
    }

    public int fixPos(int pos,HashMap<Character, Integer> hm,String s,int start){

        int p = hm.get(s.charAt(pos));

        while(p > start){
            if(hm.get(s.charAt(p)) > hm.get(s.charAt(pos))){
                return fixPos(p,hm,s,start);
            }
            p--;
        }
        return hm.get(s.charAt(pos));
    }
}

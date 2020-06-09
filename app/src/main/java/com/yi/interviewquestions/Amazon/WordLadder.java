package com.yi.interviewquestions.Amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        if(wordList == null || wordList.size() == 0) return count;

        boolean[] traveled = new boolean[wordList.size()];

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i = 0 ; i < size; i++){
                String s = q.poll();
                int wordListSize = wordList.size();
                for(int j = 0; j < wordListSize; j++){
                    if(isValied(s,wordList.get(j)) && !traveled[j]){
                        traveled[j] = true;
                        if(wordList.get(j).equals(endWord)){
                            return count+1;
                        }
                        q.offer(wordList.get(j));
                    }
                }
            }

        }

        return 0;
    }

    public boolean isValied(String a, String b){
        int diffs = 0;
        int i = 0; int j = 0;
        while(i<a.length() && j < b.length()){
            if(a.charAt(i) - b.charAt(j) != 0) diffs++;
            i++;j++;
        }

        if(i<a.length() || j < b.length()) return false;
        if(diffs > 1 || diffs == 0) return false;
        else return true;
    }
}

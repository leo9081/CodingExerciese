package com.yi.interviewquestions.Facebook;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    //sliding window
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h = new HashSet<>();
        int longest = 0;
        int i = 0; int j = 0;
        while(i<s.length()){
            if(!h.contains(s.charAt(i))){
                h.add(s.charAt(i++));
                longest = Math.max(longest, i-j);
            }else{
                h.remove(s.charAt(j++));
            }
        }

        return longest;

    }


    //DB solution
    public int lengthOfLongestSubstring2(String s) {
        int size = s.length();

        int[] f = new int[size+1];
        f[0] = 0;

        for(int i = 1; i<=size; i++){
            f[i] = 0;
            for(int j = 0; j<i; j++){
                if(isCorrect(s.substring(j,i))){
                    f[i] = Math.max(f[i-1],i-j);
                    break;
                }
            }
        }

        return f[size];
    }

    public boolean isCorrect(String s){
        HashSet<Character> h = new HashSet<>();

        for(int i = 0 ;i < s.length(); i++){
            if(h.contains(s.charAt(i))) return false;
            h.add(s.charAt(i));
        }

        return true;
    }

}

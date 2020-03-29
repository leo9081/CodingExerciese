package com.yi.interviewquestions.Uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    //ababbb longest 3

    public int lss(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }

    public static void main(String[] args){
        LongestSubString ls = new LongestSubString();
        String input = "abccdefghijklmn";
        int r = ls.lss(input);
        System.out.println(r);

    }

}
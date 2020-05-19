package com.yi.interviewquestions.Facebook;

public class ValidPalindrome {

    //Character has the function to check
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }

        return true;
    }

    // Will not pass if write this in the interview.
    public boolean isPalindrome2(String s) {
        if(s == null || s.length() == 0) return true;

        int start = 0; int end = s.length() -1;
        //int flag = false;
        while(start < end){
            while(start<end && !isVaild(s.charAt(start))) start++;
            while(start<end && !isVaild(s.charAt(end))) end--;

            if(start<end){
                if(converter(s.charAt(start))!=converter(s.charAt(end))) return false;
            }
            start++; end--;
        }

        return true;
    }

    public int converter(char c){

        if(c - 'A' >= 32) return c-'A' - 32;
        else return c- 'A';
    }

    public boolean isVaild(char c){
        return (c >= 48 && c <= 57)||(c-'a' <= 26 && c-'a'>=0) || (c -'A' <= 26  && c-'A'>= 0);
    }
}

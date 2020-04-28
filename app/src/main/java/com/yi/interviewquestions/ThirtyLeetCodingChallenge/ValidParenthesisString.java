package com.yi.interviewquestions.ThirtyLeetCodingChallenge;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int leftcount = 0;

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '(' ||s.charAt(i) == '*'){
                leftcount++;
            }else {
                leftcount--;
            }

            if(leftcount < 0) return false;
        }
        if(leftcount == 0) return true;

        int rightcount = 0;


        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == ')' ||s.charAt(i) == '*'){
                rightcount++;
            }else {
                rightcount--;
            }

            if(rightcount < 0) return false;
        }


        return true;

    }
}

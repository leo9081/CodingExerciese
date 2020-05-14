package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        StringBuilder temp = new StringBuilder();
        backtrack(temp, combinations, n);
        return combinations;
    }

    //backtrack
    //for loop the length/2
    //result list each time add ( -> move to next
    //if list.size = 2 * length add result

    public void backtrack(StringBuilder temp, List<String> result, int n){
        if(temp.length() == n*2){
            String t = temp.toString();
            if(is_val(t)){
                result.add(t);
            }
            return;
        }

        temp.append('(');
        backtrack(temp,result,n);
        temp.deleteCharAt(temp.length() -1);

        temp.append(')');

        backtrack(temp,result,n);

        temp.deleteCharAt(temp.length() -1);

    }

    public boolean is_val(String t){
        int balance = 0;
        for (int i =0 ; i < t.length(); i++) {
            if (t.charAt(i) == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

}

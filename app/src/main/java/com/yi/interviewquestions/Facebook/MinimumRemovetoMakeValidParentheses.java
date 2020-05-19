package com.yi.interviewquestions.Facebook;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        // stack recode   '(_' + 'pos'
        // if ) stack pop;

        // if)  but (  == 0 remove ')'

        //outer loop if stack !=0 remove at each pos

        StringBuilder sb = new StringBuilder(s);
        Stack<String> st = new Stack<>();
        int count = 0;

        for(int i = 0; i< s.length(); i++){

            if(s.charAt(i) == ')'){
                if(st.isEmpty()){
                    sb.delete(i-count,i-count+1);
                    count++;
                }
                else{st.pop();}
            }

            if(s.charAt(i) == '('){
                st.push('('+"_"+ (i-count+""));
            }
        }

        System.out.println(sb.toString());
        while(!st.isEmpty()){
            String temp = st.pop();
            int pos = Integer.parseInt(temp.substring(2,temp.length()));
            System.out.println(pos);
            sb.delete(pos,pos+1);
        }

        return sb.toString();
    }
}

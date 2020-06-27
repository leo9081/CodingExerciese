package com.yi.interviewquestions.Facebook;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push("( " + sb.length());
                sb.append(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(!st.isEmpty()){
                    st.pop();
                    sb.append(s.charAt(i));
                }
            }else{
                sb.append(s.charAt(i));
            }
        }

        while(!st.isEmpty()){
            String t = st.pop();
            int pos = Integer.parseInt(t.substring(2));
            sb.deleteCharAt(pos);
        }

        return sb.toString();
    }
}

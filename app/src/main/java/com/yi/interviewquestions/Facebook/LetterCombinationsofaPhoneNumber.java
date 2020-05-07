package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    Map<Character,String> h = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;


        //key,value <2, "abc">
        h.put('2',"abc");
        h.put('3',"def");
        h.put('4',"ghi");
        h.put('5',"jkl");
        h.put('6',"mno");
        h.put('7',"pqrs");
        h.put('8',"tuv");
        h.put('9',"wxyz");


        StringBuilder temp = new StringBuilder();
        backtracking(digits,result,temp,0);

        return result;
    }

    public void backtracking(String digits, List<String> result, StringBuilder temp, int digPos){
        if(temp.length() == digits.length()){
            result.add(temp.toString());
            return;
        }

        String input = h.get(digits.charAt(digPos));
        for(int i = 0; i< input.length(); i++){
            temp.append(input.charAt(i));
            backtracking(digits,result,temp,digPos+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}

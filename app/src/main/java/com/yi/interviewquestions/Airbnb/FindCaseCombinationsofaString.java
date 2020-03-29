package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class FindCaseCombinationsofaString {

    public List<String> FindCaseCombinationsofaString(String text){


        List<List<Character>> input = new ArrayList<>();

        for(int i = 0; i< text.length();i++){
            List<Character> inputC = new ArrayList<>();

            if((text.charAt(i) - 'a')<0){
                inputC.add(text.charAt(i));
                inputC.add((char)('a'+ text.charAt(i)- 'A'));
            }else{
                inputC.add(text.charAt(i));
                inputC.add((char)('A'+ text.charAt(i) - 'a'));
            }

            input.add(inputC);
        }
        List<String> result = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        dfs(input,result,temp,text.length(),0);

        return result;

    }

    public void dfs(List<List<Character>> input, List<String> result, List<Character> temp, int wordSize, int pos){
        if(temp.size() == wordSize){
            result.add(temp.toString());
            return;
        }

        for(int i =0; i< 2; i++){
            temp.add(input.get(pos).get(i));
            dfs(input,result,temp,wordSize,pos+1);
            temp.remove(temp.size()-1);
        }
    }
}

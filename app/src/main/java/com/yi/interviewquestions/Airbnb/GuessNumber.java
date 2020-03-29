package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuessNumber {

    String target;

    public GuessNumber(String target) {
        this.target = target;
    }

    public String findNumber(){
        //create 4 1-6 list
        List<List<Integer>> input = new ArrayList<>();
        for(int i = 0; i<6; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j< 6; j++){
                temp.add(j+1);
            }
            input.add(temp);
        }
        List<Integer> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        dfs(input,0,temp,result);


        return result.get(0);
    }


    public void dfs(List<List<Integer>> input, int pos, List<Integer> temp,List<String> result){
        String a = temp.toString();
        if(temp.toString().equalsIgnoreCase(target)){
            result.add(temp.toString());
            return;
        }
        if(temp.size() > target.length()){
            return;
        }

        for(int i = pos; i< input.size();i++){
            if(input.get(pos).get(i) == (target.charAt(pos)-'0')) {
                temp.add(input.get(pos).get(i));
                dfs(input, pos + 1, temp, result);
                temp.remove(input.get(pos).get(i));
            }
        }
    }


}

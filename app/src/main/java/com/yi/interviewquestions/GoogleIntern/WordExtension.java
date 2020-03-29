package com.yi.interviewquestions.GoogleIntern;

import java.util.ArrayList;
import java.util.List;

public class WordExtension {

    public List<int[]> repeatWord(String input){
        List<int[]> result = new ArrayList<>();
        int start = 0;
        for(int i = 1; i<input.length(); i++){
            while(i<input.length() && input.charAt(i) == input.charAt(start)){
                i++;
            }
            if(i - start >=3) {
                int[] r = new int[]{start, i-1};
                result.add(r);
            }
            start = i;
        }
        return result;
    }

    public static void main(String[] arg){
        WordExtension we = new WordExtension();
        List<int[]> result = we.repeatWord("heeellooowwww");
        for(int i = 0; i< result.size(); i++){
            System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
        }

    }
}

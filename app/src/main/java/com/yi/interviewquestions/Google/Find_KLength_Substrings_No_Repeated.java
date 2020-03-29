package com.yi.interviewquestions.Google;

import java.util.HashMap;

public class Find_KLength_Substrings_No_Repeated {

    public int solution(String s, int k){

        int start = 0; int count = 0;
        HashMap<Character,Integer> h = new HashMap<>();

        for(int end = 0; end < s.length(); end++){
            if(h.containsKey(s.charAt(end))){
                //assign char+1
                int pos = h.get(s.charAt(end))+1;
                //clear the hashmap with the char before repeat char
                for(int i = start; i<pos; i++){
                    h.remove(s.charAt(i));
                }
                //start from the char+1
                start = pos;
            }

            h.put(s.charAt(end),end);

            if(end - start + 1 == k){
                count++;
                h.remove(s.charAt(start));
                start++;
            }

        }

        return count;
    }

    public static void main(String[] args){
        Find_KLength_Substrings_No_Repeated f = new Find_KLength_Substrings_No_Repeated();
        //String input = "banana";
        String input = "loooongerwithrepeat";
        //int k = 10;
        int k = 8;
        int result = f.solution(input,k);
        System.out.println(result);
    }
}

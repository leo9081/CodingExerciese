package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> result = new HashSet<>();

        HashMap<String, Integer> h = new HashMap<>();
        //put all words into hash with index
        for(int i = 0; i < words.length; i++){
            h.put(words[i],i);
        }

        //loop the list
        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            for(int j = 0; j <= w.length(); j++){
                String a = w.substring(0,j);
                String b = w.substring(j);

                if(isPalindrome(a) && h.containsKey(revString(b)) && h.get(revString(b))!= i){
                    List<Integer>  temp = new ArrayList<>();
                    temp.add(h.get(revString(b)));
                    temp.add(i);
                    result.add(temp);
                }
            }

            w =revString(w);

            for(int j = 0; j <= w.length(); j++){
                String a = w.substring(0,j);
                String b = w.substring(j);

                if(isPalindrome(a) && h.containsKey(b) && h.get(b)!= i){
                    List<Integer>  temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(h.get(b));
                    result.add(temp);
                }
            }

        }

        Iterator<List<Integer>> iterator = result.iterator();
        List<List<Integer>> res = new ArrayList<>();

        while(iterator.hasNext()){
            res.add(iterator.next());
        }

        return res;
    }

    public String revString(String s){
        return new StringBuffer(s).reverse().toString();
    }

    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}

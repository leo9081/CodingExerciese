package com.yi.interviewquestions.Facebook.AlienDictionary;

import java.util.HashMap;

public class VerifyingAlienDictionary {


    public boolean isAlienSorted2(String[] words, String order) {
        // find first different char
        // chack position of order
        search:for(int i = 1; i< words.length; i++){
            String s1 = words[i];
            String s0 = words[i-1];


            for(int j = 0; j<Math.min(s1.length(),s0.length());j++){

                if(s1.charAt(j) != s0.charAt(j)){

                    if(order.indexOf(s1.charAt(j)) < order.indexOf(s0.charAt(j))){
                        return false;
                    }
                    continue search;
                }
            }

            if(s1.length() < s0.length()) return false;
        }

        return true;
    }



    public boolean isAlienSorted(String[] words, String order) {
        //run order in hashmap
        HashMap<Character, Integer> hs = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            hs.put(order.charAt(i), i);
        }

        //go through three words together
        search:
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i];
            String w2 = words[i - 1];

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {

                    if (hs.get(w1.charAt(j))
                            < hs.get(w2.charAt(j))) {
                        //System.out.println(w1.charAt(j) + " " + w2.charAt(j));
                        return false;
                    }
                    continue search;
                }

            }

            if (w1.length() < w2.length())
                return false;
        }

        return true;
    }


}

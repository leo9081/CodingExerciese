package com.yi.interviewquestions.Facebook;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.N)
public class FindAnagram {

    // use sliding window
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i= 0; i< p.length(); i++){
            hm.put(p.charAt(i), hm.getOrDefault(p.charAt(i),0)+1);
        }

        List<Integer> output = new ArrayList();
        HashMap<Character,Integer> count = new HashMap<>();

        for(int i =0; i< s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i),0)+1);

            if(i>=p.length()){
                char temp = s.charAt(i-p.length());
                if(count.get(temp) == 1){
                    count.remove(temp);
                }else count.put(temp, count.get(temp) - 1);

            }

            if(count.equals(hm)) output.add(i-p.length()+1);
        }

        return output;
    }


    //!!!!! Time is too long!!!!!
    //problem each time we need loop through the substring create new hashmap
    // with sliding window, we just modify the original hashmap

    //put 2nd string in to hashSet
    // if there are same characters? HashMap
    //loop through 1st string,
    // if find alph in hashSet, subString the length and check
    //      check: loop through subString create hashMap
    //      compare two hashmap
    // else move to next;

    public int firstIndex(String a, String b){
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i = 0; i < b.length(); i++){
            if(hm.containsKey(b.charAt(i))){
                hm.put(b.charAt(i),hm.get(b.charAt(i))+1);
            }else{
                hm.put(b.charAt(i),1);
            }

        }

        for(int i = 0; i< a.length()-b.length(); i++){
            if(hm.containsKey(a.charAt(i)) && isAnagrm(a.substring(i,i+b.length()),hm)) return i;
        }

        return -1;
    }

    public boolean isAnagrm(String input, HashMap<Character,Integer> hm){
        HashMap<Character,Integer> count = new HashMap<>();
        for(int i =0; i< input.length(); i++){
            if(!hm.containsKey(input.charAt(i))) return false;

            if(count.containsKey(input.charAt(i))){
                count.put(input.charAt(i),count.get(input.charAt(i))+1);
                if(count.get(input.charAt(i))>hm.get(input.charAt(i))) return false;
            }else{
                count.put(input.charAt(i),1);
            }
        }

        for(Map.Entry<Character,Integer> entry: hm.entrySet()){
            if(count.get(entry.getKey()) != entry.getValue()) return false;
        }

        return true;
    }

    public static void main(String[] args){
        String a = "jfjgsiuvsernnhvasnkjjbejrbwehfonsdkvbjkd";
        String b = "ejnkbs";
        FindAnagram f = new FindAnagram();
        int reuslt = f.firstIndex(a,b);
        System.out.println(reuslt);
    }

}

package com.yi.interviewquestions.Google;

import java.util.ArrayList;

public class HashMapWithExpiration {

    ArrayList<Integer>[] text;

    public void HashMapWithExpiration(){
        text = new ArrayList[10001];
        for(int i = 0; i< text.length; i++){
            text[i] = new ArrayList<>();
        }

    }

    public void put(int k, int v, int exp){
        text[k].add(v);
        text[k].add(exp);
        checkExp();

    }

    public int get(int k){
        return text[k].get(0);

    }

    public void remove(int k){
        text[k] = new ArrayList<>();
    }

    public void checkExp(){
        for(int i = 0; i< text.length; i++){
            int count = text[i].get(1)-1;
            if(count == 0) remove(i);
            else text[i].add(1,count);
        }
    }

}

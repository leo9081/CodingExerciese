package com.yi.interviewquestions.Amazon;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    class ResultType{
        String word;
        int count;
        public ResultType(String word,int count){
            this.word = word;
            this.count = count;
        }
    }

    class RtCompare implements Comparator<ResultType> {
        public int compare(ResultType a, ResultType b){
            if(a.count == b.count){
                return alphcompare(a,b);
            }else{
                return b.count - a.count;
            }
        }

        public int alphcompare(ResultType a, ResultType b){
            String s1 = a.word; String s2 = b.word;
            for(int i = 0; i < Math.min(s1.length(),s2.length()); i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    return s1.charAt(i) - s2.charAt(i);
                }
            }
            return s1.length() - s2.length();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<ResultType> pq = new PriorityQueue<>(words.length, new RtCompare());

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i = 0 ; i< words.length; i++){
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }

        for(Map.Entry<String,Integer> entry: hm.entrySet()){
            pq.add(new ResultType(entry.getKey(),entry.getValue()));
        }

        List<String> result = new ArrayList<>();
        while(k>0){
            result.add(pq.poll().word);
            k--;
        }

        return result;
    }
}

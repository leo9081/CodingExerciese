package com.yi.interviewquestions.WeeklyConttest.WC192;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ThekStrongestValuesinanArray {
    int mid = 0;

    class pqComparater implements Comparator<Integer> {
        public int compare(Integer a, Integer b){
            int x = Math.abs(a-mid);
            int y = Math.abs(b-mid);
            if(x == y) return b - a;
            return y - x;
        }
    }
    public int[] getStrongest(int[] arr, int k) {
        int[] result = new int[k];
        if(arr ==null || arr.length == 0) return result;
        if(arr.length == 1){
            result[0] = arr[0];
            return result;
        }

        int[] temp = arr.clone();
        Arrays.sort(temp);
        mid = temp[(temp.length-1)/2];

        PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length, new pqComparater());
        for(int i:arr){
            pq.offer(i);
        }

        int i = 0;
        while(i<k){
            result[i] = pq.poll();
            i++;
        }

        return result;
    }
}

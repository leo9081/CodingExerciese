package com.yi.interviewquestions.Facebook.intersections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1 ||intervals.length == 0) return intervals;
        List<int[]> r = new ArrayList<>();

        for(int[] i: intervals) r.add(i);

        Collections.sort(r,new listComparator());

        int i = 0 ; int j = i+1;
        while(j < r.size()){
            if(r.get(j)[0] <= r.get(i)[1]){
                if(r.get(i)[1] < r.get(j)[1]){
                    r.get(i)[1] = r.get(j)[1];
                }
                r.remove(j);
            }else{
                i++; j++;
            }
        }

        return r.toArray(new int[r.size()][]);
    }

    class listComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }
}

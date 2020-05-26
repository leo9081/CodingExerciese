package com.yi.interviewquestions.Facebook.intersections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1 ||intervals.length == 0) return intervals;
        //if a[0] < b[0]: b[0]
        //if a[1] > b[1]: b[1]
        List<int[]> r = new ArrayList<>();

        for(int[] i: intervals) r.add(i);

        Collections.sort(r,new listComparator());

        int i = 0 ; int j = i+1;
        while(j < r.size()){
            int lo = Math.max(r.get(i)[0], r.get(j)[0]);
            int hi = Math.min(r.get(i)[1], r.get(j)[1]);
            if(lo <= hi){
                lo = Math.min(r.get(i)[0], r.get(j)[0]);
                hi = Math.max(r.get(i)[1], r.get(j)[1]);
                r.get(i)[0] = lo;
                r.get(i)[1] = hi;
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

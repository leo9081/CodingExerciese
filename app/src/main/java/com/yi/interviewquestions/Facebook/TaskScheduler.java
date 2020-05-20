package com.yi.interviewquestions.Facebook;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        Arrays.sort(tasks);
        int i = 0;
        while(i < tasks.length){
            int count = 0;
            char c = tasks[i];

            while(i < tasks.length && tasks[i] == c){
                count++;
                i++;
            }
            pq.offer(count);
        }

        //System.out.println(pq.peek() + " " + n );
        // size = 8; n = 2; 4,3,1   k 0 result 9
        while(!pq.isEmpty()){
            //System.out.println(size);
            int k = 0;
            List<Integer> remain = new ArrayList<>();
            while( k <= n){
                if(!pq.isEmpty()){
                    int task = pq.poll()-1;

                    if(task > 0) remain.add(task);
                }
                result++;
                if(pq.isEmpty() && remain.size() == 0){
                    break;
                }
                k++;
            }

            for(Integer l: remain) pq.offer(l);

        }

        return result;
    }
}

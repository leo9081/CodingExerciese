package com.yi.interviewquestions.Google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        List<Integer>[] path = new ArrayList[1001];

        for(int i=0;i<1001;i++){
            path[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            if(!path[edge[0]].isEmpty()
                    &&!path[edge[1]].isEmpty()
                    && dfs(edge[0],edge[1],path)){
                return edge;
            }

            path[edge[0]].add(edge[1]);
            path[edge[1]].add(edge[0]);
        }

        return new int[2];
    }

    public boolean dfs(int start, int end, List<Integer>[] path){
        if(path[start].size() == 0 || path[end].size() == 0 ) return false;

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> h = new HashSet<>();

        q.offer(start);
        h.add(start);

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == end) return true;
            for(int i = 0; i< path[node].size(); i++){
                if(!h.contains(path[node].get(i))){
                    q.offer(path[node].get(i));
                    h.add(path[node].get(i));
                }
            }

        }

        return false;
    }

}

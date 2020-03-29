package com.yi.interviewquestions.Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class findShortestCycle {

/*
    int count;
    public int sulotion(){
        count = Integer.MIN_VALUE;
        for(int i=0; i<g.size; i++){
            if(!visited[i]){
                int c = 0;
                dfs(g,i,c);
            }
        }

        return count;
    }

    public void dfs(Graph g,int pos, int c){
        visited[pos] = true;

        for(int i: g.adj(pos)){
            if(!visited[i]){
                dfs(g,i,c);
            }
        }

        c++;
        count= Math.min(count,c);
    }

    public void BFS(Node start){

        Queue<Node> q = new LinkedList<>();
        HashSet<Node> h = new HashSet<>();

        q.offer(start);
        h.add(start);

        while(!q.isEmpty()){
            Node temp = q.poll();
            result.add(temp);
            for(int i = 0; i< temp.neighbours; i++){

                if(!h.contains(temp.neighbours.get(i))) {
                    q.offer(temp.neighbours.get(i));
                    h.add(temp.neighbours.get(i));
                }


            }


        }

    }*/
}

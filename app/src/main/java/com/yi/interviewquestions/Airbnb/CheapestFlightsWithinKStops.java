package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<HashMap<Integer,Integer>> distCost = new ArrayList<>();
        List<List<Integer>> dist = new ArrayList<>();
        HashMap<Integer, List<List<Integer>>> h = new HashMap<>();

        for(int i = 0; i < flights.length;i++){
            List<Integer> temp = new ArrayList<>();
            dist.add(i,temp);
            h.put(i,new ArrayList<List<Integer>>());
            distCost.add(i,new HashMap<Integer, Integer>());
        }

        if(dist.size()-1 < dst) {
            return -1;
        }

        for(int i = 0; i < flights.length;i++){
            dist.get(flights[i][0]).add(flights[i][1]);
            distCost.get(flights[i][0]).put(flights[i][1], flights[i][2]);
        }



        BFS(dist,src,dst,h);

        if(!h.containsKey(dst)){
            return -1;
        }

        List<List<Integer>> path = h.get(dst);
        int minCost = Integer.MAX_VALUE;

        for(int i=0; i<path.size(); i++){
            List<Integer> singlePath = path.get(i);
            int cost = 0;
            if(singlePath.size()-1 <= K+1 && singlePath.size()!=0){
                for(int j = 1; j < singlePath.size();j++){
                    cost += distCost.get(singlePath.get(j-1)).get(singlePath.get(j));
                }
                minCost = Math.min(cost,minCost);
            }
        }

        if(minCost == Integer.MAX_VALUE) return -1;
        else return minCost;

    }

    public void BFS(List<List<Integer>> input, int src, int target, HashMap<Integer, List<List<Integer>>> h){

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hset = new HashSet<>();

        q.offer(src);
        //hset.add(src);

        while(!q.isEmpty()){
            int parent = q.poll();
            if(input.size()-1 < parent){
                return;
            }
            List<Integer> children = input.get(parent);

            for(int i = 0; i< children.size();i++) {
                q.offer(children.get(i));
                List<List<Integer>> parentList = h.get(parent);
                List<List<Integer>> childrenList = h.get(children.get(i));

                if (parentList.size() == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(parent);
                    temp.add(children.get(i));
                    childrenList.add(temp);
                } else {
                    for (int j = 0; j < parentList.size(); j++) {
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(parentList.get(j));
                        temp.add(children.get(i));
                        childrenList.add(temp);
                    }
                }
            }



        }

    }
}

package com.yi.interviewquestions.Facebook;

import java.util.Stack;

public class IsGraphBipartite {
    //dfs
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(color[i] == 0) {
                Stack<Integer> s = new Stack<>();
                s.push(i);
                color[i] = -1;

                while (!s.isEmpty()) {
                    int node = s.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == 0) {
                            color[nei] = -color[node];
                            s.push(nei);
                        }else if(color[nei] == color[node]){
                            return false;
                        }
                    }

                }
            }

        }

        return true;
    }


    //recurtion
    public boolean isBipartite2(int[][] graph) {
        int[] colors = new int[graph.length];


        for(int i = 0; i < graph.length;i++){
            if(colors[i] == 0 && !isValied(colors,i,graph,1)) return false;
        }

        return true;
    }

    public boolean isValied(int[] colors, int pos, int[][] graph, int color){
        if(colors[pos]!=0) return colors[pos] == color;

        colors[pos] = color;

        for(int i = 0; i< graph[pos].length; i++){
            if(!isValied(colors,graph[pos][i],graph, -color)) return false;
        }
        return true;
    }
}

package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class MinimumNumofNodesTraverseEntireGraph {

    public class Graph{
        private int size = 0;
        private LinkedList<Integer> adj[];
        public Graph(int size){
            this.size = size;
            adj = new LinkedList[size];
            for (int i=0; i<size; ++i)
                adj[i] = new LinkedList();
        }

        public void addEdge(int v, int w){
            adj[v].add(w);
        }

        public int size(){
            return size;
        }

        public List<Integer> adjs(int v){

            List<Integer> result = new ArrayList<>();
            Iterator<Integer> j =adj[v].listIterator();
            while(j.hasNext())
                result.add(j.next());

            return result;
        }

        public Graph reversG(){
            Graph g = new Graph(size);
            for (int i = 0; i < size; i++)
            {
                // Recur for all the vertices adjacent to this vertex
                Iterator<Integer> j =adj[i].listIterator();
                while(j.hasNext())
                    g.adj[j.next()].add(i);
            }
            return g;
        }


    }

    public class Solution{


        public Solution(){

        }

        Stack<Integer> s = new Stack<>();
        boolean[] visited;
        List<Integer> temp;
        List<List<Integer>> result;
        Graph orgGraph;
        public List<List<Integer>> getAllSCC(Graph g){
            result = new ArrayList<>();
            orgGraph = g;
            visited = new boolean[g.size()];

            for(int i = 0; i< g.size; i++){
                visited[i] = false;
            }

            for(int i=0; i<g.size; i++){
                if(!visited[i]){
                    dfs(g,i);
                }
            }

            Graph revGraph =g.reversG();
            for(int i = 0; i< g.size; i++){
                visited[i] = false;
            }

            while(!s.isEmpty()){
                int tmp = s.pop();
                temp = new ArrayList<>();
                if(!visited[tmp]){
                    dfs2(revGraph,tmp);
                    result.add(temp);
                }
            }

            return result;
        }

        public List<Integer> findDAG(){
            Graph newG = new Graph(result.size());

            for(int i = 0; i< result.size() ;i++){

                for(int j = 0; j< result.get(i).size(); j++){
                    Integer nodeInSCC = result.get(i).get(j);

                    if(orgGraph.adjs(nodeInSCC).size()!=0){
                        for(int k = 0; k<orgGraph.adjs(nodeInSCC).size(); k++){
                            if(!result.get(i).contains(orgGraph.adjs(nodeInSCC).get(k))){
                                newG.addEdge(result.get(i).get(0),orgGraph.adjs(nodeInSCC).get(k));
                            }
                        }
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            HashMap<Integer, Integer> h = new HashMap<>();

            for(int i =0; i< newG.size(); i++){
                if(newG.adjs(i).size()!=0) {

                    for (int j = 0; j < newG.adjs(i).size(); j++) {
                        Integer key = newG.adjs(i).get(j);
                        if (h.containsKey(key)) {
                            h.put(key, h.get(key) + 1);
                        } else {
                            h.put(key, 1);
                        }
                    }
                    if (h.containsKey(i)) {
                        h.put(i, h.get(i));
                    } else {
                        h.put(i, 0);
                    }
                }

            }

            for(Integer key: h.keySet()){
                if(h.get(key) == 0){
                    res.add(key);
                }
            }

            return res;

        }

        public void dfs(Graph g, int v){
            visited[v] = true;
            for(int i: g.adjs(v)){
                if(!visited[i]){
                    dfs(g,i);
                }
            }
            s.push(v);
        }

        public void dfs2(Graph g, int v){
            visited[v] = true;
            for(int i: g.adjs(v)){
                if(!visited[i]){
                    dfs2(g,i);
                }
            }
            temp.add(v);
        }


    }

}

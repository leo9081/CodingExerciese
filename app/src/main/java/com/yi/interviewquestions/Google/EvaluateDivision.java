package com.yi.interviewquestions.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static android.media.CamcorderProfile.get;

public class EvaluateDivision {
    class Node{
        String c;
        List<HashMap<Node, Double>> hlist;

        public Node(String c, List<HashMap<Node, Double>> hlist){
            this.c = c;
            this.hlist = hlist;
        }

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Node headNode = null;
        HashMap<String,Node> hs = new HashMap<>();

        for(int i = 0; i< equations.size(); i++){
            for(int j = 0; j < equations.get(i).size(); j++){
                Node n = new Node(equations.get(i).get(j),new ArrayList<HashMap<Node, Double>>());
                hs.put(equations.get(i).get(j),n);
            }
        }

        for(int i = 0; i< equations.size(); i++){
            for(int j = 0; j < equations.get(i).size(); j++){
                HashMap<Node, Double> h = new HashMap();

                Node n = hs.get(equations.get(i).get(j));
                if(j == 0){
                    h.put(hs.get(equations.get(i).get(j+1)),values[i]);
                    n.hlist.add(h);
                }else{
                    h.put(hs.get(equations.get(i).get(j-1)),(double)1/values[i]);
                    n.hlist.add(h);
                }

            }
        }

        double[] result = new double[queries.size()];

        for(int i = 0; i< queries.size();i++){
            HashMap<Node,Double> res = new HashMap<>();
            if(!hs.containsKey(queries.get(i).get(0)) || !hs.containsKey(queries.get(i).get(1))){
                result[i] = -1;
                continue;
            }

            if(queries.get(i).get(0).equalsIgnoreCase(queries.get(i).get(1))){
                result[i] = 1;
                continue;
            }

            bfs2(hs.get(queries.get(i).get(0)), hs.get(queries.get(i).get(1)), res);

            if(res.containsKey(hs.get(queries.get(i).get(1)))){
                result[i] = res.get(hs.get(queries.get(i).get(1)));
            }else {
                result[i] = -1;
            }
        }

        return result;

    }

    public void bfs2(Node start, Node end, HashMap<Node,Double> result){
        Queue<Node> s = new LinkedList<>();
        HashSet<Node> hs = new HashSet<>();

        s.offer(start);
        hs.add(start);
        while(!s.isEmpty()){
            Node n = s.poll();

            for(int i = 0; i< n.hlist.size(); i++){
                for(Node key:n.hlist.get(i).keySet()){
                    if(!hs.contains(key)) {
                        if(result.containsKey(n)){
                            result.put(key,result.get(n)*n.hlist.get(i).get(key));
                        }else{
                            result.put(key,n.hlist.get(i).get(key));
                        }

                        hs.add(key);
                        if (key.c.equalsIgnoreCase(end.c)) {
                            return;
                        } else {
                            s.offer(key);
                        }
                    }
                }
            }

        }

    }

}

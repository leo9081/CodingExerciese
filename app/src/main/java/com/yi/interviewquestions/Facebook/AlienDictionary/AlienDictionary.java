package com.yi.interviewquestions.Facebook.AlienDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    //first difference letter between two words shows the order of the letter
    // difference letter after the first difference letter is irrelevant
    // find first different letter

    //When we have a set of relations, often drawing a graph is the best way to visualize them.

    //** did not pass the case ["abc","ab"], if u know how th modify the code and get it pass
    //please message me.

    class Node{
        char c;
        int prevCount;
        List<Node> next;

        public Node(char c, List<Node> next){
            this.c = c;
            this.prevCount = 0;
            this.next = next;
        }
    }

    public String alienOrder(String[] words){
        HashMap<Character, Node> dNode = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                List<Node> t = new ArrayList<>();
                Node n = new Node(c,t);
                dNode.put(c, n);
            }
        }

        search: for(int i = 1; i < words.length; i++){
            String a = words[i];
            String b = words[i-1];

            for(int j = 0; j< Math.min(a.length(), b.length()); j++){

                if(a.charAt(j) != b.charAt(j)){

                    Node tempa = dNode.get(a.charAt(j));
                    Node tempb = dNode.get(b.charAt(j));

                    tempb.prevCount += 1;
                    List<Node> tempnext = tempa.next;
                    tempnext.add(tempb);
                    tempa.next = tempnext;

                    dNode.put(a.charAt(j), tempa);
                    dNode.put(b.charAt(j),tempb);

                    continue search;
                }

            }

        }

        //loop through HashMap,
        //get Node and is incomming count. create Queue for no
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Integer> hm = new HashMap<>();

        for(Node value : dNode.values()){
            if(value.prevCount == 0) q.offer(value);
            hm.put(value,value.prevCount);

            //System.out.println(value.c + " " + value.prevCount);
        }


        return bfs(hm,q);
    }

    public String bfs(HashMap<Node, Integer> graph, Queue<Node> q){
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Node temp = q.poll();
            sb.append(temp.c);

            for(Node n: temp.next){
                graph.put(n,graph.get(n)-1);
                if(graph.get(n) == 0) q.offer(n);
            }
        }

        return sb.reverse().toString();
    }

}

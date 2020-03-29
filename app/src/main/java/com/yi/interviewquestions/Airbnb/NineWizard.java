package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NineWizard {

    //1 : 6
    //3: 5
    //5: 9
    //6: 1,3
    //9
    // source 1 target 9

    // all the number that has 0 in degree and 0 out degree can be removed
    //

    public class Solution {
        public List<List<Integer>> getShortestPath(List<List<Integer>> wizards, int source, int target) {

            List<List<Integer>> result = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();

            HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
            for(int i = 0; i < 10; i++){
                List<List<Integer>> temp = new ArrayList<>();
                map.put(i,temp);
            }

            BFS(wizards, source, map);

            List<List<Integer>> test = map.get(target);
            return test;


        }

        //get all the path from source - target
        public void BFS(List<List<Integer>> wizards, int source, HashMap<Integer, List<List<Integer>>> map) {

            Queue<Integer> q = new LinkedList<>();

            q.offer(source);

            while (!q.isEmpty()) {
                int parent = q.poll();
                List<Integer> temp = wizards.get(parent);

                if(temp.size()>0) {
                    for (int i = 0; i < temp.size(); i++) {
                        q.offer(temp.get(i));

                        //which can go to parent
                        List<List<Integer>> ttt = map.get(parent);
                        //which can go to child
                        List<List<Integer>> targetList = map.get(temp.get(i));

                        if(ttt.size() == 0){
                            List<Integer> tt = new ArrayList<>();
                            tt.add(parent);
                            tt.add(temp.get(i));
                            targetList.add(tt);
                            map.put(temp.get(i), targetList);
                        }else {
                            List<Integer> t = new ArrayList<>();
                            t.addAll(ttt.get(ttt.size()-1));
                            t.add(temp.get(i));
                            targetList.add(t);
                            map.put(temp.get(i), targetList);
                        }

                    }
                }
            }

        }

    }
}

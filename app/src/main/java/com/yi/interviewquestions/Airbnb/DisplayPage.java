package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DisplayPage {
    public class Solution {

        public List<String> displayPages(List<String> input, int pageSize) {

            Iterator<String> iterator = input.iterator();
            List<String> visited = new ArrayList<>();
            List<String> result = new ArrayList<>();
            Boolean reachEnd = false;
            while(iterator.hasNext()){
                String temp = iterator.next();
                String hostId = temp.split(",")[0];
                if(!visited.contains(hostId) || reachEnd){
                    result.add(temp);
                    visited.add(hostId);
                    iterator.remove();
                }

                if(visited.size() == pageSize){
                    reachEnd = false;
                    if (!input.isEmpty()) {
                        result.add(" ");
                    }
                    visited.clear();
                    iterator = input.iterator();
                }

                if(!iterator.hasNext()){
                    reachEnd = true;
                    iterator = input.iterator();
                }

            }

            return result;
        }

    }
}

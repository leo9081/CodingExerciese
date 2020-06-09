package com.yi.interviewquestions.Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<String> LetLog = new PriorityQueue<>(logs.length, new LetComparator());
        List<String> DigLog = new ArrayList<>();

        for(String log: logs){
            String[] temp = log.split(" ");
            if(!Character.isLetter(temp[1].charAt(0))){
                DigLog.add(log);
            }else{
                LetLog.add(log);
            }
        }

        String[] result = new String[logs.length];
        int c = 0;
        while(!LetLog.isEmpty()){
            result[c++]=LetLog.poll();
        }

        for(String s: DigLog){
            result[c++] = s;
        }

        return result;
    }

    class LetComparator implements Comparator<String> {
        public int compare(String a, String b){
            String[] tempa = a.split(" ");
            String[] tempb = b.split(" ");
            for(int i = 1 ; i < Math.min(tempa.length, tempb.length); i++){
                int x = 0; int y = 0;
                while(x < tempa[i].length() && y < tempb[i].length()){
                    if(tempa[i].charAt(x) != tempb[i].charAt(y)){
                        return tempa[i].charAt(x) - tempb[i].charAt(y);
                    }
                    x++;y++;
                }
                if(x < tempa[i].length()){
                    return 1;
                }
                if(y < tempb[i].length()){
                    return -1;
                }
            }

            int x = 0; int y = 0;
            while(x < tempa[0].length() && y < tempb[0].length()){
                if(tempa[0].charAt(x) != tempb[0].charAt(y)){
                    return tempa[0].charAt(x) - tempb[0].charAt(y);
                }
                x++;y++;
            }
            if(x < tempa[0].length()){
                return -1;
            }
            if(y < tempb[0].length()){
                return 1;
            }

            return 0;
        }
    }
}

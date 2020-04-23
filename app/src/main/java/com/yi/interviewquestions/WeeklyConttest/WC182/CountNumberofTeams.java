package com.yi.interviewquestions.WeeklyConttest.WC182;

import java.util.ArrayList;
import java.util.List;

public class CountNumberofTeams {
    class Solution {
        public int numTeams(int[] rating) {

            List<Integer> temp = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();

            if(rating == null || rating.length == 0) return result.size();
            findTeams(rating, temp, result, 0);

            return result.size();
        }

        public void findTeams(int[] subArr, List<Integer>temp, List<List<Integer>> result, int pos){
            if(temp.size() == 3 && isCorrect(temp)){
                //System.out.println(temp);
                result.add(new ArrayList<>(temp));
                return;
            }


            for(int i = pos; i< subArr.length;i++){
                temp.add(subArr[i]);
                findTeams(subArr, temp, result, i+1);
                temp.remove(temp.size()-1);
            }

        }

        public boolean isCorrect(List<Integer> temp){
            if((temp.get(0)<temp.get(1)&&temp.get(1)<temp.get(2))
                    ||(temp.get(0)>temp.get(1)&&temp.get(1)>temp.get(2))){
                return true;
            }
            return false;
        }
    }
}

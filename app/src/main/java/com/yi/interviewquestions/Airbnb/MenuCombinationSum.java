package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuCombinationSum {

    public List<List<Double>> getCombos(double[] prices, double target) {

        List<Double> temp = new ArrayList<>();
        List<List<Double>> result = new ArrayList<>();

        bfs(prices,target,0,temp,result);

        return result;
    }

    public void bfs(double[] prices, double target, int pos, List<Double> temp, List<List<Double>> result){

        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<0){
            return;
        }

        for(int i = pos ; i < prices.length; i++){
            temp.add(prices[i]);
            bfs(prices,target-prices[i],pos+1,temp,result);
            temp.remove(temp.size()-1);
        }

    }
}

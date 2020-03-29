package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RoundPrice {

    /*
    Given an array of numbers A = [x1, x2, ..., xn] and T = Round(x1+x2+... +xn).
    We want to find a way to round each element in A such that after rounding we get a new array B = [y1, y2, ...., yn]
    such that y1+y2+...+yn = T where yi = Floor(xi) or Ceil(xi), ceiling or floor of xi.

    We also want to minimize sum |x_i-y_i|
     */


    public int[] RoundPrice(double[] A){
        List<Double> reminder = new ArrayList<>();
        List<Double> shadowReminder = new ArrayList<>();
        int[] floorTemp = new int[A.length];
        int floorSum = 0;
        double realSum = 0;

        for(int i = 0; i< A.length; i++){
            floorTemp[i] = (int)Math.floor(A[i]);
            reminder.add(i,A[i] - floorTemp[i]);
            shadowReminder.add(i,A[i] - floorTemp[i]);
            floorSum += floorTemp[i];
            realSum += A[i];
        }

        int realRound = (int)Math.round(realSum);
        if(floorSum == realRound) return floorTemp;

        int diff = realRound - floorSum;

        Collections.sort(reminder,Collections.<Double>reverseOrder());

        for(int i = 0; i< diff ; i++){
            int index = shadowReminder.indexOf(reminder.get(i));
            floorTemp[index] = (int)Math.ceil(A[index]);
        }

        return floorTemp;

    }



}

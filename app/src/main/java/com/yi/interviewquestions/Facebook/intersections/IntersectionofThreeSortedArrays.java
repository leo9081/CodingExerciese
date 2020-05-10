package com.yi.interviewquestions.Facebook.intersections;

import java.util.ArrayList;
import java.util.List;

public class IntersectionofThreeSortedArrays {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<Integer>();

        int s1 = 0; int s2 = 0; int s3 = 0;
        int l1 = arr1.length; int l2 = arr2.length; int l3 = arr3.length;
        while(s1<l1 && s2<l2 && s3 <l3){

            if(arr1[s1] == arr2[s2] && arr2[s2] == arr3[s3]){
                result.add(arr1[s1]);
                s1++;s2++;s3++;
            }else if(arr1[s1] < arr2[s2]){
                s1++;
            }else if(arr2[s2] < arr3[s3]){
                s2++;
            }else{
                s3++;
            }

        }

        return result;
    }
}

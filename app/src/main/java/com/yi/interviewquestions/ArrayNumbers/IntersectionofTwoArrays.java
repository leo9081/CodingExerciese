package com.yi.interviewquestions.ArrayNumbers;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        int m = nums1.length;
        int n = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> result = new HashSet<Integer>();

        while(m>0 && n >0){
            if(nums1[m-1] == nums2[n-1]){
                result.add(nums1[m-1]);
                m--;
                n--;
            }else if(nums1[m-1] < nums2[n-1]){
                n--;
            }else{
                m--;
            }
        }

        int[] r = new int[result.size()];
        int index = 0;
        for(Integer i: result){
            r[index] = (int)i;
            index++;
        }

        return r;
    }
}

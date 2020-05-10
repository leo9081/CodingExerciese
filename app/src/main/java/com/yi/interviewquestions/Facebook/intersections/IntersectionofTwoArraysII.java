package com.yi.interviewquestions.Facebook.intersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionofTwoArraysII {

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); Arrays.sort(nums2);
        int start1 = 0; int start2 = 0;
        int l1 = nums1.length; int l2 = nums2.length;
        List<Integer> r = new ArrayList<>();
        while(start1 < l1 && start2 < l2){
            if(nums1[start1] == nums2[start2]){
                r.add(nums1[start1]);
                start1++;
                start2++;
            }else if(nums1[start1] > nums2[start2]){
                start2++;
            }else{
                start1++;
            }
        }

        int[] result = new int[r.size()];
        for(int i = 0; i< r.size(); i++){
            result[i] = r.get(i);
        }

        return result;
    }


    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length < nums2.length){
            return helper(nums1,nums2);
        }else{
            return helper(nums2,nums1);
        }
    }

    public int[] helper(int[] baseArray, int[] targetArray){
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i< baseArray.length; i++){
            if(hm.containsKey(baseArray[i])){
                hm.put(baseArray[i],hm.get(baseArray[i])+1);
            }else{
                hm.put(baseArray[i], 1);
            }
        }

        for(int i = 0; i< targetArray.length; i++){
            if(hm.containsKey(targetArray[i]) && hm.get(targetArray[i])>0){
                result.add(targetArray[i]);
                hm.put(targetArray[i],hm.get(targetArray[i])-1);

            }
        }
        int[] r =  new int[result.size()];
        for(int i = 0; i< result.size(); i++){
            r[i] = result.get(i);
        }

        return r;
    }
}

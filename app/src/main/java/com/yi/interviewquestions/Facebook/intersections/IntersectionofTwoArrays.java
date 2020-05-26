package com.yi.interviewquestions.Facebook.intersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        IntersectionofTwoArrays s = new IntersectionofTwoArrays();

        int[] result = s.intersection(nums1, nums2);

        for(int i = 0 ; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    /*This is a Facebook interview question.
    They ask for the intersection, which has a trivial solution using a hash or a set.

    Then they ask you to solve it under these constraints:
    O(n) time and O(1) space (the resulting array of intersections is not taken into consideration).
    You are told the lists are sorted.

    Cases to take into consideration include:
    duplicates, negative values, single value lists, 0's, and empty list arguments.
    Other considerations might include
    sparse arrays.
*/

    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int p1 = 0; int p2 = 0;

        while(p1<nums1.length && p2 < nums2.length){
            int t1 = nums1[p1]; int t2 = nums2[p2];

            if(t1 == t2){
                result.add(t1);
                while(p1<nums1.length && nums1[p1] == t1) p1++;
                while(p2<nums2.length && nums2[p2] == t2) p2++;
            }else if(t1 > t2){
                while(p2<nums2.length && nums2[p2] == t2) p2++;
            }else{
                while(p1<nums1.length && nums1[p1] == t1) p1++;
            }
        }

        int[] r = new int[result.size()];
        int c = 0;
        for(int a: result){
            r[c] = a;
            c++;
        }

        return r;
    }


    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
            if (set2.contains(s)) output[idx++] = s;

        return Arrays.copyOf(output, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }



    public int[] intersection4(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        int l1 = nums1.length;
        int l2 = nums2.length;


        if(l1 == 0|| l2 == 0) return new int[0];

        HashMap<Integer, Integer> hm = new HashMap<>();




        if(l1 < l2){
            for(int i = 0;i<l1; i++){
                hm.put(nums1[i],0);
            }

            for(int j = 0; j< l2; j++){
                if(hm.containsKey(nums2[j])){
                    hm.put(nums2[j],hm.get(nums2[j])+1);
                }
            }

        }else{
            for(int i = 0;i<l2; i++){
                hm.put(nums2[i],0);
            }

            for(int j = 0; j< l1; j++){
                if(hm.containsKey(nums1[j])){
                    hm.put(nums1[j],hm.get(nums1[j])+1);
                }
            }
        }

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue()>0) {
                result.add(entry.getKey());
            }
        }

        int[] r = new int[result.size()];
        int c = 0;
        for(int a: result){
            r[c] = a;
            c++;
        }

        return r;

    }
}

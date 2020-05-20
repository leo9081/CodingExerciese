package com.yi.interviewquestions.Facebook;

import java.util.HashSet;

public class IntersectionofTwoArrays {

    /*This is a Facebook interview question.
    They ask for the intersection, which has a trivial solution using a hash or a set.

    Then they ask you to solve it under these constraints:
    O(n) time and O(1) space (the resulting array of intersections is not taken into consideration).
    You are told the lists are sorted.

    Cases to take into consideration include:
    duplicates, negative values, single value lists, 0's, and empty list arguments.
    Other considerations might include
    sparse arrays.


    function intersections(l1, l2) {
        l1.sort((a, b) => a - b) // assume sorted
        l2.sort((a, b) => a - b) // assume sorted
    const intersections = []
        let l = 0, r = 0;
        while ((l2[l] && l1[r]) !== undefined) {
       const left = l1[r], right = l2[l];
            if (right === left) {
                intersections.push(right)
                while (left === l1[r]) r++;
                while (right === l2[l]) l++;
                continue;
            }
            if (right > left) while (left === l1[r]) r++;
            else while (right === l2[l]) l++;

        }
        return intersections;
    }
*/



    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        IntersectionofTwoArrays s = new IntersectionofTwoArrays();

        int[] result = s.intersection(nums1, nums2);

        for(int i = 0 ; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();

        for(int i: nums1) h1.add(i);
        for(int i: nums2) h2.add(i);

        int[] result;

        if(nums1.length < nums2.length){
            result = new int[nums1.length];
            helper(h1,h2,result);
        }else{
            result = new int[nums2.length];
            helper(h2,h1,result);
        }

        return result;
    }

    public void helper(HashSet<Integer> h1, HashSet<Integer> h2, int[] result){
        int idx =0;
        for(Integer i: h1){
            if(h2.contains(i)){
                result[idx++] = i;
            }
        }
    }
}

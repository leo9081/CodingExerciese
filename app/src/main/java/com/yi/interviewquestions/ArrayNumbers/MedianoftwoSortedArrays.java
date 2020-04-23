package com.yi.interviewquestions.ArrayNumbers;

public class MedianoftwoSortedArrays {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length+B.length;

        if(m%2 == 0){
            return (helper(A,0,B,0,m/2)+helper(A,0,B,0,m/2+1))/2.0;
        }

        return helper(A,0,B,0,m/2+1);
    }

    public int helper(int[] A, int startA, int[] B, int startB, int k){

        if(startA >= A.length){
            return B[startB+k/2-1];
        }

        if(startB >= B.length){
            return A[startA+k/2-1];
        }

        if(k==1){
            return Math.min(A[startA],B[startB]);
        }

        int halfKthA = startA+k/2-1 < A.length? A[startA+k/2-1] : Integer.MAX_VALUE;
        int halfKthB = startA+k/2-1 < A.length? A[startA+k/2-1] : Integer.MAX_VALUE;

        return halfKthA<halfKthB? helper(A,startA+k/2,B,startB,k-k/2):
                helper(A,startA+k/2,B,startB,k-k/2);
    }

}

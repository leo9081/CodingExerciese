package com.yi.interviewquestions.ArrayNumbers;

public class MergeTwoSortedArrays {

    public int[] mergeSortedArray(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        int[] result = new int[m+n];
        int p = m+n-1;

        while(m>0 && n>0){
            if(A[m-1]>B[n-1]){
                result[p] = A[m-1];
                m--;
            }else{
                result[p] = B[n-1];
                n--;
            }
            p--;
        }

        while(m>0){
            result[p] = A[m-1];
            m--;
            p--;
        }

        while(n>0){
            result[p] = B[n-1];
            n--;
            p--;
        }
        return result;
    }

}

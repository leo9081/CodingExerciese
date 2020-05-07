package com.yi.interviewquestions.Facebook;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if(A.length == 0 || A.length == 1) return true;

        boolean isIncresing = true;
        if(A[A.length-1] - A[0] < 0){
            isIncresing = false;
        }

        for(int i = 1; i< A.length; i++){
            if(isIncresing && A[i] < A[i-1]) return false;
            if(!isIncresing && A[i] > A[i-1]) return false;
        }

        return true;
    }
}

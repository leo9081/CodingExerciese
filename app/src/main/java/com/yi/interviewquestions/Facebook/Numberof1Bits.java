package com.yi.interviewquestions.Facebook;

public class Numberof1Bits {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i = 0; i< 32; i++){
            if((n & mask) != 0){
                count++;
            }

            mask <<= 1;
        }

        return count;
    }
}

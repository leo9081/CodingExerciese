package com.yi.interviewquestions.ThirtyLeetCodingChallenge;

public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {

        int l = 0;
        while(l < shift.length){
            if(shift[l][0] == 0){
                //shiftToLeft(s,shift[l][1]);
                int cuttingPos = shift[l][1];
                String s1 = s.substring(0,cuttingPos);
                String s2 = s.substring(cuttingPos,s.length());
                s = s2+s1;
            }else{
                int cuttingPos = s.length() -shift[l][1];
                String s1 = s.substring(0, cuttingPos);
                String s2 = s.substring(cuttingPos,s.length());
                s = s2+s1;
            }
            l++;
        }

        return s;
    }

    public static void main(String[] args){
        PerformStringShifts p = new PerformStringShifts();
    }

}

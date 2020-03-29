package com.yi.interviewquestions.Google;

import java.util.Arrays;

public class Compare_Strings {

    public int[] Solution(String A, String B){
        //String A - > String list
        String[] strsA = A.split(",");
        String[] strsB = B.split(",");

        //loop list A
        // count all the number in the list
        // [a:5, a:2 , b:3, c7]
        // [2,3,5,7]
        int[] Aint = new int[strsA.length];
        for(int i = 0; i< strsA.length; i++){
            char[] temp = strsA[i].toCharArray();
            Arrays.sort(temp);
            int count = 1;
            for(int j = 1; j<temp.length; j++){
                if(temp[j] == temp[0]) count++;
                else break;
            }
            Aint[i] = count;
        }

        //loop list B
        //  [3, 4]
        int[] Bint = new int[strsB.length];
        for(int i = 0; i< strsB.length; i++){
            char[] temp = strsB[i].toCharArray();
            Arrays.sort(temp);
            int count = 1;
            for(int j = 1; j<temp.length; j++){
                if(temp[j] == temp[0]) count++;
                else break;
            }
            Bint[i] = count;
        }

        Arrays.sort(Aint);
        int[] result = new int[Bint.length];
        for(int i = 0; i< Bint.length; i++){
            result[i] = findSmallerNumber(Aint,Bint[i]);
        }

        return result;
    }

    //find last element < target
    public int findSmallerNumber(int[] input, int target){
        int start = 0;
        int end = input.length-1;
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if(input[mid] == target) end = mid;
            else if(input[mid] > target) end = mid;
            else start = mid;
        }
        //3,4 ,5   2 - > 0;
        //1,2,6   3 ->
        if(input[start] >= target){
            if(start == 0) return 0;
            else return start ;
        }else{
            if(input[end] >= target){
                return start+1;
            }else return end+1;
        }
    }

    public static void main(String[] args){
        Compare_Strings cs = new Compare_Strings();
        //String A = "abcd,aabc,bd";
        //String B = "aaa,aa";
        String A = "ab,aab,bbbc,ddde";
        String B = "aaaa,aaa,aa,a";
        int[] result = cs.Solution(A,B);
        for(int i: result) System.out.println(i);
    }
}

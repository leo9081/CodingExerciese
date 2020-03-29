package com.yi.interviewquestions.GoogleIntern;

public class BinarySum {
    /*
        Given two binary strings, return their sum (also a binary string).
Example 1:
Input: a = "0", b = "1"
Output: "1"
Example 2:
Input: a = "11", b = "1"
Output: "100"
     */

    public String bAdd(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while(i >= 0 || j >= 0){
            int sum = carry;
            if( i>=0 ) sum += a.charAt(i) - '0';
            if( j>=0 ) sum += b.charAt(j) - '0';
            sb.append(sum%2);
            carry = sum /2;
        }

        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();

    }

}

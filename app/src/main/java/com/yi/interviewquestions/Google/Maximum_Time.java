package com.yi.interviewquestions.Google;

public class Maximum_Time {
    public static String maxTime(String time){

        if(time == null || time.length() == 0) throw new IllegalArgumentException("Empty input");

        char[] timeChar = time.toCharArray();

        if((timeChar[0] != '?' && Character.getNumericValue(timeChar[0]) > 2)
                || (timeChar[3] != '?' && Character.getNumericValue(timeChar[3])>5)){
            throw new IllegalArgumentException("Wrong input");
        }
        if(timeChar[0] != '?' && timeChar[1] != '?'
                && Character.getNumericValue(timeChar[0])==2
                && Character.getNumericValue(timeChar[1]) > 3){
            throw new IllegalArgumentException("Wrong input");
        }

        if(timeChar[4] == '?') timeChar[4] = '9';
        if(timeChar[3] == '?') timeChar[3] = '5';
        if(timeChar[1] == '?'){
            if(Character.getNumericValue(timeChar[0])==2 || timeChar[0] == '?'){
                timeChar[1] = '3';
            }else{
                timeChar[1] = '9';
            }
        }if(timeChar[0] == '?') {
            if (Character.getNumericValue(timeChar[1]) > 3) {
                timeChar[0] = '1';
            } else {
                timeChar[0] = '2';
            }
        }
        System.out.println(String.copyValueOf(timeChar));
        return String.copyValueOf(timeChar);
    }


    public static void main(String[] args) {
        maxTime("23:5?");// 23:59
        maxTime("2?:22");// 23:22
        maxTime("0?:??");// 09:59
        maxTime("1?:??");// 19:59
        maxTime("?4:??");// 14:59
        maxTime("?3:??");// 23:59
        maxTime("??:??");// 23:59
        maxTime("?4:5?"); //14:59
        maxTime("?4:??"); //14:59
        maxTime("?3:??"); //23:59
        maxTime("?9:4?"); //19:49
    }
}

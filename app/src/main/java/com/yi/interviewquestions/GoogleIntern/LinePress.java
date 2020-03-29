package com.yi.interviewquestions.GoogleIntern;

public class LinePress {

    public String line_press(String input){
        char[] chars = input.toCharArray();
        String result = "";
        for(int i = 0; i<chars.length; i++){
            if(chars[i]=='_'){
                while(chars[i] == '_'){
                    i++;
                }
                result+='_';
            }
            result+=chars[i];

        }

        return result;
    }

    public static void main(String[] args){
        LinePress lp = new LinePress();
        String input= "a___b__c_d";
        String result = lp.line_press(input);
        System.out.println(result);
    }

}

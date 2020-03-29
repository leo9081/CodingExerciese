package com.yi.interviewquestions.Random;

public class WordCompression {


    public String compressWord(String input, int K){
        String str = checkRepeat(input,K);
        if(str.equalsIgnoreCase(input)) return input;

        return compressWord(str, K);

    }
    //abbcccb
    public String checkRepeat(String input, int K){
        if(input == null|| input.length() == 0) return input;

        for(int i = 1; i< input.length(); i++){
            if(input.charAt(i) == input.charAt(i-1)){
                int count = i;
                while(count < i-1+K && input.charAt(i-1) == input.charAt(count)){
                    count++;
                }
                if(count-i == K-1){
                    String a = input.substring(0,i-1);
                    String b = input.substring(i-1+K);
                    return a+b;
                }
                i = count;
            }
        }
        return input;
    }

}

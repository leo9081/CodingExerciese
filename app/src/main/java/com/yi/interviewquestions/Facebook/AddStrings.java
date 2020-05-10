package com.yi.interviewquestions.Facebook;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int c = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;

        StringBuilder s = new StringBuilder();

        while(i>=0&&j>=0){
            int sum = num1.charAt(i)-'0'+num2.charAt(j)-'0'+c;
            c = sum/10;
            sum = sum%10;
            s.append(sum);

            i--;
            j--;
        }

        while(i>=0){
            int sum = num1.charAt(i)-'0'+c;
            c = sum/10;
            sum = sum%10;
            s.append(sum);

            i--;
        }

        while(j>=0){
            int sum = num2.charAt(j)-'0'+c;
            c = sum/10;
            sum = sum%10;
            s.append(sum);

            j--;
        }

        if(c>0){
            s.append(c);
        }

        return s.reverse().toString();
    }
}

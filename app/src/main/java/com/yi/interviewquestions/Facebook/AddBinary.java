package com.yi.interviewquestions.Facebook;

public class AddBinary {
    public String addBinary(String a, String b) {

        int c = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();

        while(i>=0 && j >=0){
            int r = a.charAt(i) - '0' + b.charAt(j) - '0' + c;
            c = r/2;
            r = r%2;

            sb.append(r+"");
            --i;
            --j;
        }

        while(i>=0){
            int r = a.charAt(i) - '0' + c;
            c = r/2;
            r = r%2;
            sb.append(r+"");
            --i;
        }

        while(j>=0){
            int r = b.charAt(j) - '0' + c;
            c = r/2;
            r = r%2;
            sb.append(r+"");
            --j;
        }

        if(c > 0){
            sb.append(c+"");
        }

        sb.reverse();

        return sb.toString();
    }
}

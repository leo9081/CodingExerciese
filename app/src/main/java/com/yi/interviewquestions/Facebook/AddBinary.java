package com.yi.interviewquestions.Facebook;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();

        int pa = a.length()-1; int pb = b.length()-1;
        int c = 0;
        while(pa >=0 && pb>=0){
            int r = a.charAt(pa)-'0' + b.charAt(pb)-'0'+c;

            c = r/2;
            r = r%2;

            sb.append(r);
            pa--; pb--;
        }

        while(pa >=0){
            int r = a.charAt(pa)-'0'+c;

            c = r/2;
            r = r%2;

            sb.append(r);
            pa--;
        }

        while(pb>=0){
            int r = b.charAt(pb)-'0'+c;

            c = r/2;
            r = r%2;

            sb.append(r);
            pb--;
        }

        if(c>0){
            sb.append(c);
        }

        return sb.reverse().toString();

    }
}

package com.yi.interviewquestions.Facebook;

public class IntegertoEnglishWords {
    public String one(int i){
        switch(i){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    public String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    public String two(int num){
        if(num == 0) return "";
        if(num < 10) return one(num);
        if(num < 20) return twoLessThan20(num);
        else {
            if(num%10 > 0){
                return ten(num/10) + " " + one(num%10);
            }else {
                return ten(num/10);
            }
        }
    }

    public String three(int num){
        String h = one(num / 100);
        String rest = two(num % 100);
        if( h != "" && rest != ""){
            return h + " Hundred " + rest;
        }else if(h != "" && rest == ""){
            return h + " Hundred";
        }else if(h == "" && rest != ""){
            return rest;
        }

        return "";
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        int billian = num/1000000000;
        int million = (num - billian * 1000000000)/1000000;
        int thousand = (num - billian * 1000000000 - million*1000000)/1000;
        int rest = num - billian * 1000000000 - million*1000000 - thousand*1000;

        String result = "";
        if(billian>0) result += three(billian) + " Billion";
        if(million>0) {
            if (! result.isEmpty()) result += " ";
            result += three(million) + " Million";
        }
        if(thousand>0) {
            if (! result.isEmpty()) result += " ";
            result += three(thousand) + " Thousand";
        }
        if(rest>0) {
            if (! result.isEmpty()) result += " ";
            result += three(rest);
        }

        return result;
    }

    public static void main(String[] args) {

    }

}

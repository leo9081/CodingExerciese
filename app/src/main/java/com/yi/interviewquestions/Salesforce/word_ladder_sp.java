package com.yi.interviewquestions.Salesforce;

import java.util.Arrays;
import java.util.Stack;

public class word_ladder_sp {
    /*给定dictionary of words, start word。求由start word组成的最长的在dictionary中的词。
    e.g. start word: at
    dictionary: chat, hat, chats, bat.
            answer: at->hat->chat->chats, 答案是4.
    if dictionary: hat, chats, bat
    answer: at->hat, 答案是2.*/

    //sort() hat, bat, chats
    // find first word longer then start word
    // hat, hat base bfs.. bat base bfs ...

    int pos;
    String[] dict;
    public String wordladder_sp(String start_word, String[] dict){

        //Arrays.sort(dict);
        this.dict = dict;
        //return bfs(start_word) - start_word.length()+1;
        return bfs(start_word);
    }
    int max = 0;
    String result = "";

    public String bfs(String sw){
        Stack<String> s = new Stack<>();

        s.push(sw);
        while(!s.isEmpty()){
            String temp = s.pop();
            if(temp.length() > max){
                max = temp.length();
                result = temp;
            }
            //max = Math.max(temp.length(), max);

            for(int i= 0; i< dict.length; i++){
                if(dict[i].contains(temp) && dict[i].length() - temp.length() == 1){
                    s.push(dict[i]);
                }
            }

        }

        return result;
    }

    public static void main(String[] args){
        word_ladder_sp wls = new word_ladder_sp();
        String start_word = "at";
        String[] dict = new String[]{ "hat", "bat","hate", "chate","chates","bate","bates"};
        String result = wls.wordladder_sp(start_word,dict);
        System.out.println(result);
    }

}

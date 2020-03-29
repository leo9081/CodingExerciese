package com.yi.interviewquestions.GoogleIntern;

import java.util.Arrays;
import java.util.Collections;

public class WordPrefix {

    class TrieNode{

        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        public TrieNode(){
            isEndOfWord = false;
            for(int i = 0; i< 26; i++){
                children[i] = null;
            }
        }

    }

    TrieNode root;

    public boolean isWordPrefix(String[] inputs){
        root = new TrieNode();

        for(int i = 0; i< inputs.length; i++){
            //if is prefix return 0, else return 1;
            boolean x = isPrefix(root,inputs[i]);
            if(x) return true;

        }
        root = new TrieNode();

        for(int i = inputs.length -1 ; i>=0 ; i--){
            //if is prefix return 0, else return 1;
            boolean x = isPrefix(root,inputs[i]);
            if(x) return true;
        }

        return false;
    }

    public boolean isPrefix(TrieNode root, String input){
        boolean flag = true;
        for(int i = 0; i < input.length(); i++){
            int index = input.charAt(i)-'a';
            if(root.children[index]==null){
                root.children[index] = new TrieNode();
                root = root.children[index];
                flag = false;
            }else{
                root = root.children[index];
            }

        }
        if(!flag){
            root.isEndOfWord = true;
        }

        return flag;
    }

    public static void main(String[] args){
        String[] inputs = new String[]{"abce","abcd","zxc","poi"};
        WordPrefix wp = new WordPrefix();
        boolean result = wp.isWordPrefix(inputs);
        System.out.println(result);

    }
}

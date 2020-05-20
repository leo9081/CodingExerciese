package com.yi.interviewquestions.Facebook;

public class WordDictionary {
    class TreeNode{
        boolean isWord;
        TreeNode[] children;
        public TreeNode(){
            children = new TreeNode[26];
            for(int i = 0; i< 26; i++){
                children[i] = null;
            }
            isWord = false;
        }

    }


    TreeNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode p = root;

        for(int i = 0; i< word.length(); i ++){
            if(p.children[word.charAt(i) - 'a'] == null){
                p.children[word.charAt(i) - 'a'] = new TreeNode();
            }
            p = p.children[word.charAt(i) - 'a'];
        }

        p.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, 0, root);
    }

    public boolean find(String word, int pos, TreeNode node){
        if(pos == word.length()){
            return node.isWord;
        }

        if(word.charAt(pos) == '.'){
            for(int i = 0 ; i < node.children.length; i++){
                if(node.children[i]!=null){
                    if(find(word,pos+1,node.children[i])) return true;
                }
            }
            return false;
        }else if(node.children[word.charAt(pos) - 'a'] != null){
            return find(word,pos+1,node.children[word.charAt(pos) - 'a']);
        }else{
            return false;
        }

    }
}

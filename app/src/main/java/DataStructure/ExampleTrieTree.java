package DataStructure;

class TrieNode{
    boolean isWord;
    TrieNode[] children;

    public TrieNode(){
        children = new TrieNode[26];
        for(int i = 0 ; i < 26; i++){
            children[i] = null;
        }
        isWord=false;
    }
}

public class ExampleTrieTree {

    TrieNode root;

    public ExampleTrieTree(){
        root= new TrieNode();
    }

    public void addWord(String word){
        TrieNode p = root;

        for (int i = 0; i < word.length(); i++) {
            if(p.children[word.charAt(i)-'a'] == null){
                p.children[word.charAt(i)-'a'] = new TrieNode();
            }
            p =  p.children[word.charAt(i)-'a'];
        }

        p.isWord = true;
    }

    public boolean searchWord(String word){
        return find(word,0,root);
    }

    public boolean find(String word, int pos, TrieNode node){
        if(pos == word.length()){
            if(node.isWord) return true;
        }

        if(word.charAt(pos) == '.'){
            for(int i = 0; i < node.children.length;i++){
                if(node.children[i]!=null) {
                    if (find(word, pos + 1, node.children[i])) return true;
                }
            }
            return false;
        }else if(node.children[word.charAt(pos)-'a']!=null){
            return find(word,pos+1,node.children[word.charAt(pos)-'a']);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        ExampleTrieTree exampleTrieTree = new ExampleTrieTree();

        exampleTrieTree.addWord("apple");
        exampleTrieTree.addWord("banana");
        exampleTrieTree.addWord("pinapple");
        exampleTrieTree.addWord("balance");

        boolean r1 = exampleTrieTree.searchWord("balance");
        boolean r2 = exampleTrieTree.searchWord("ball");
        boolean r3 = exampleTrieTree.searchWord("app..");

        System.out.println(r1 + " " + r2 + " " + r3);

    }
}

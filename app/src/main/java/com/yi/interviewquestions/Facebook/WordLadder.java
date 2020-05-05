package com.yi.interviewquestions.Facebook;

public class WordLadder {
/*
    Hello?

    // hait heot
    // two words can be transfor
    public boolean trans(String a, String b){


        return true;
    }

    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

// start from the end words : cog
// if	cog is in the word list
// what words can be transfor from cog
//

    hit
            hot
    dot           lot
    dog          log
    cog

    public int dist(String a, String b) {
        if a == null || a.empty():
        throw Exception("Invalid Arg")
        if a.length() != b.length():
        throw Exception("Invalid Arg")
        len = a.length()
        int dist = 0
        for i = 0; i < len; i++:
        if a.charAt(i) != b.charAt(i):
        dist++
        return dist
    }

    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    hs: hot, dot, lot,
    q: dot,lot
    //bfs
    public void bfs(String s, String end, List<String> result, Sting[] dic){
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.offer(s);

        while(!q.isEmpty()){
            String temp = q.poll();
            if(dist(temp, end) <=1 ){
                result.add(end);
                return;
            }

            for(int i = 0; i< dic.length; i++){
                if(dist(temp, dic[i]) <=1 && !hs.contains(dic[i])){
                    q.offer(dic[i]);
                    hs.add(dic[i]);
                }
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, Sting[] wordList) {

        dic = wordList;
        List<String> result = new ArrayList<>();
        bfs(beginWord,endWord,result, wordList);

        return result.size();

    }

    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]



    // temp: dog
// temp_dep 4
// q:  dog, log
// dep: 4, 4
// cp_wl:  ["cog"]
// wl:   ["cog"]
    public int ladderLen(String begin, String end, Set<String> wl) {
        int short_dist = dist(begin, end)
        if short_dist <= 1:
        return short_dist + 1
        Set<String> cp_wl = new Set(wl)
        Queue<String> q = new LinkedList()
        Queue<Integer> dep = new LinkedList()
        q.add(begin)
        dep.add(1)
        while(!q.empty()) {
            int temp_dep = dep.offer()
            String temp = q.offer()
            if dist(temp, end) <= 1:
            return temp_dep + dist(temp, end)
            for w in wl:
            if dist(temp, w) == 1:
            q.add(w)
            dep.add(temp_dep+1)
            cp_wl.remove(w)
            wl = cp_wl
        }
        return 0
    }

    //dfs
    public int short_dist(string begin, string end, Set<string> dict):
            if begin == end:
            return 0
            if dist(begin, end) == 1:
            return 1
            if dict.empty():
            return int.MAX
    Set<String> cp_dict = new Set(dict)
    Set<String> child = new Set() // Empty
    for word in dict:
            if dist(begin, end) == 1:
            cp_dict.remove(word)
            child.add(word)
    dist = int.MAX
    for word in child:
    dist = math.min(dist, short_dist(word, end, cp_dict))
            if dist == 0 || dist == 1:
            return dist + 1
            if dist == int.MAX:
            return int.MAX
    return dist + 1

*/

}

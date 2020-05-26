package com.yi.interviewquestions.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。
手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。
即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 */

public class ColoredCircle {

    LRUCache lruCache;

    public ColoredCircle(int ColorNumber,int c){
        lruCache = new LRUCache(ColorNumber,c);
    }

    public int CheckErrorColors(List<List<Integer>> colorInPos){

        int count = 0;

        for(int i = 0; i < colorInPos.size(); i++){
            List<Integer> colorList = colorInPos.get(i);
            for(int j = 0; j< colorList.size(); j++) {

                int color = colorList.get(j);

                if(lruCache.containsNumber(color)){
                    count++;
                    continue;
                }

                lruCache.addNumber(color);

            }
            lruCache.roundOver();
            lruCache.print();
        }

        return count;
    }

    public static void main(String[] args) {
        ColoredCircle coloredCircle = new ColoredCircle(3,2);
        List<Integer> l1 = new ArrayList<>();
        l1.add(1); l1.add(2); l1.add(3);
        List<Integer> l2 = new ArrayList<>();

        List<Integer> l3 = new ArrayList<>();
        l3.add(1); l3.add(3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(1); l4.add(2);

        List<List<Integer>> input = new ArrayList<>();
        input.add(l1);input.add(l2);input.add(l3);input.add(l4);input.add(l1);
        int result = coloredCircle.CheckErrorColors(input);

        System.out.println(result);
    }


}

class LRUCache{
    int size;
    int spaceNum;
    HashMap<Integer, Integer> hashMap;

    public LRUCache(int size, int spaceNum){
        this.size = size;
        this.spaceNum = spaceNum;
        this.hashMap = new HashMap<>();
    }

    public void addNumber(int num){
        hashMap.put(num,spaceNum);
    }

    public boolean containsNumber(int num){
        return hashMap.containsKey(num);
    }

    public void roundOver(){
        for(Iterator<Map.Entry<Integer, Integer>> it = hashMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, Integer> entry = it.next();
            int count = entry.getValue()-1;
            if(count == 0) {
                it.remove();
                continue;
            }
            entry.setValue(count);
        }

    }

    public void print(){
        for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}

package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom {

    HashMap<Integer, Integer> hm;
    List<Integer> l;
    Random rand = new Random();
    int index;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        hm = new HashMap<>();
        l = new ArrayList<Integer>();
        index = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;

        l.add(val);
        hm.put(val,index);
        index++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    //No matter how we delete it, it will change the index of the list.
    //so we have to switch the val with the last index value. so the current index will not be changed.
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;

        int lastIndex = hm.get(l.get(l.size()-1));
        int i = hm.get(val);

        hm.put(l.get(l.size()-1), i);
        l.set(i, l.get(lastIndex));

        l.remove(l.size()-1);
        hm.remove(val);

        index--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return l.get(rand.nextInt(index));
    }
}

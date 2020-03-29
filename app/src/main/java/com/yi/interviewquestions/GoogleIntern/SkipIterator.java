package com.yi.interviewquestions.GoogleIntern;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SkipIterator implements Iterator {
    /*
        Given an iterator (of integers) with next() and hasNext(), implement another iterator with next(), hasNext(), and skip(element). skip(element) will skip the next occurrence of the given element in the underlying iterator. If it's called n times, it will skip the next n occurrences of the given element.
SkipIterator itr = new SkipIterator([2, 3, 4, 3]);
itr.hasNext(); // true
itr.next(); // returns 2
Â 
itr.skip(4);
itr.next(); // returns 5
itr.next()// return 3;
2334
itr.skip(3);
itr.skip(3);
itr.next()// return 2
itr.next()// return 4
     */

        Map<Integer,Integer> skipCount = new HashMap();
        Iterator itr;
        Object cur;

	    public SkipIterator(List<Integer> arr){
            itr = arr.iterator();
            if(!itr.hasNext()) return;
            cur = itr.next();
        }

	    public void skip(Integer i){
            if(!skipCount.containsKey(i)){
                skipCount.put(i, 0);
            }
            skipCount.put(i, skipCount.get(i) + 1);
        }

        public Integer next(){
            if(!hasNext()) return -1;
            return (Integer)cur;
        }

        public boolean hasNext(){
            if(cur == null) return false;
            while(cur != null && skipCount.containsKey(cur)){
                int count = skipCount.get(cur);
                if(count == 1){
                    skipCount.remove(cur);
                }
                skipCount.put((Integer)cur, count-1);
                cur = itr.next();
            }
            return cur != null;

    }

    /*
    SkipIterator itr = new SkipIterator([2, 3, 4, 3]);
itr.hasNext(); // true
itr.next(); // returns 2
itr.skip(4);
itr.hasNext() // true
        itr.next(); // returns 3
itr.hasNext() // true
        itr.next()// return 3;
    */

}

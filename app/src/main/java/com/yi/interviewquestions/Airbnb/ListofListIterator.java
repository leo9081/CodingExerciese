package com.yi.interviewquestions.Airbnb;

import java.util.Iterator;
import java.util.List;

public class ListofListIterator {

    public class Solution{


        /*Given an array of arrays, implement an iterator class to allow the client to traverse
        and remove elements in the array list.

        This iterator should provide three public class member functions:

        boolean hasNext() return true if there is another element in the set
        int next() return the value of the next element in the array
        void remove() remove the last element returned by the iterator. That is, remove the element
        that the previous next() returned. This method can be called only once per call to next(),
        otherwise an exception will be thrown.

        [ [1,2,3,4,5,6],
          [7,8,9,1,4,8],
          [0,5,6,7]
        ]

        */



    }

    class Solution2{

        int total;
        int cur;
        boolean nextselect;
        List<List<Integer>> list;
        Iterator<List<Integer>> outerListIterator;
        Iterator<Integer> innerListIterator;

        public Solution2(List<List<Integer>> list) {
            this.list = list;
            nextselect = false;
            for(List<Integer> sublist : list) {
                total += sublist.size();
            }
            cur = 0;

            outerListIterator = list.iterator();
            innerListIterator = outerListIterator.next().iterator();

        }

        public boolean hasNext() {
            if(innerListIterator.hasNext()){
                return true;
            } else {
                while (!innerListIterator.hasNext() && outerListIterator.hasNext()) {
                    innerListIterator = outerListIterator.next().iterator();
                }
                if(!innerListIterator.hasNext()){
                    return false;
                }
            }
            return true;
        }


        public int next() {
            int res = 0;
            if(hasNext()) {
                while(!innerListIterator.hasNext()){
                    innerListIterator = outerListIterator.next().iterator();
                }
                nextselect = true;
                res = innerListIterator.next();
                cur++;
            }else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return res;
        }

        public void remove() {
            if(nextselect) {
                if (total >= cur) innerListIterator.remove();
                nextselect = false;
            }else{
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }



}

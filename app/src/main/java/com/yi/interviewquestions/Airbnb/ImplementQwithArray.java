package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class ImplementQwithArray {
    public class QueueWithFixedArray {

        //cycle array

        List<Object> headList;
        List<Object> tailList;
        int fixedSize;
        int head;
        int tail;
        int count;

        public QueueWithFixedArray(int fixedSize){
            headList = new ArrayList<>();
            tailList = new ArrayList<>();
            this.fixedSize = fixedSize;
            this.tail = 0;
            this.head = 0;
            this.count =0;
            this.tailList = this.headList;
        }

        public void offer(int value){
            if(tail == fixedSize-1){
                List<Object> temp = new ArrayList<>();
                temp.add(value);
                tailList.add(temp);
                tailList = temp;
                //tailList = (List<Object>) tailList.get(tail);
                tail = 0;
            }else{
                tailList.add(value);
            }
            tail++;
            count++;
        }

        public int poll(){
            if(count == 0){
                return -1;
            }

            int returnVal = (int)headList.get(head);
            head++;
            count--;

            if(head == fixedSize -1){
                List<Object> temp = (List<Object>)headList.get(head);
                headList.clear();
                headList = temp;
                head = 0;
            }
            return returnVal;
        }

        public int size(){
            return count;
        }

    }

}

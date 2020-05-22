package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumSwap {
    public int maximumSwap(int num) {
        //2736
        //7632

        List<Integer> numsList = new ArrayList<>();
        List<Integer> copyList = new ArrayList<>();
        while(num > 0){
            numsList.add(0,num%10);
            copyList.add(0,num%10);
            num = num/10;
        }

        Collections.sort(copyList,Collections.reverseOrder());

        for(int i = 0 ; i < numsList.size(); i++){
            if(numsList.get(i) < copyList.get(i)){
                int pos = numsList.lastIndexOf(copyList.get(i));
                int temp = numsList.get(i);
                numsList.set(i,numsList.get(pos));
                numsList.set(pos,temp);
                break;
            }
        }

        return ListToInt(numsList);
    }

    public int ListToInt(List<Integer> numsList){
        int num = 0;
        for(int i = 0 ; i < numsList.size(); i++){
            num = num*10;
            num += numsList.get(i);
        }
        return num;
    }
}

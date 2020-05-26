package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumSwap {

    /*
    Arrays.sort() cannot be used directly to sort primitive arrays in descending order.
    If you try to call the Arrays.sort() method by passing reverse Comparator defined by Collections.
    reverseOrder() , it will throw the error no suitable method found for sort(int[],comparator)
    That will work fine with 'Array of Objects' such as Integer array but will not work with
    a primitive array such as int array. The only way to sort a primitive array in descending order is,
    first sort the array in ascending order and then reverse the array in place.
    This is also true for two-dimensional primitive arrays.
     */
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        Integer[] Acopy = new Integer[A.length];

        for (int i = 0; i < A.length; i++) {
            Acopy[i] = A[i] - '0';
        }

        Arrays.sort(Acopy,Collections.reverseOrder());

        //for(Integer c: Acopy) System.out.println(c);

        for(int i = 0; i < A.length; i++){
            if(A[i]- '0' < Acopy[i]){
                int pos = i; int count = i;
                while(count < A.length){
                    if(A[count]- '0' == Acopy[i]) pos = count;
                    count++;
                }
                char temp = A[i];
                A[i] = A[pos];
                A[pos] = temp;
                break;
            }
        }

        return Integer.valueOf(new String(A));

    }


    public int maximumSwap2(int num) {
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

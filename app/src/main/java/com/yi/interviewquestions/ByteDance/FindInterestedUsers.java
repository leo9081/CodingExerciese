package com.yi.interviewquestions.ByteDance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，
每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。
因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
 */

public class FindInterestedUsers {
    public List<Integer> findInterestUser(List<List<Integer>> input){
        List<Integer> result = new ArrayList<>();
        if(input == null || input.size() == 0) return result;

        //get user interesting number
        List<Integer> integers = input.get(1);

        //loop from 3 - end of list for find correct user
            //findUserNumber(subarray, target);
        for(int i = 3; i < input.size(); i++){
            //validation check needed.
            int start = input.get(i).get(0)-1;
            int end = input.get(i).get(1);
            int target = input.get(i).get(2);
            int r = findUserNumber(integers.subList(start,end),target);

            result.add(r);
        }
        return result;
    }

    public int findUserNumber(List<Integer> input, int target){
        int count = 0;
        Collections.sort(input);
        int start = 0; int end = input.size()-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(input.get(mid) == target){
                int temp = mid-1;
                while(temp>=0 && input.get(temp) == target){
                    count++;
                    temp--;
                }
                while(mid < input.size() && input.get(mid) == target){
                    count++;
                    mid++;
                }
                return count;
            }else if(input.get(mid) > target){
                end = mid;
            }else {
                start = mid;
            }
        }

        if(input.get(start) == target && input.get(end) == target) {
            return 2;
        }else if(input.get(start) == target || input.get(end) == target) {
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        List<Integer> first = new ArrayList<Integer>(){{add(5);}};
        List<Integer> seconde = new ArrayList<Integer>(){{add(1);add(2);add(3);add(3);add(5);}};
        List<Integer> third = new ArrayList<Integer>(){{add(3);}};
        List<Integer> forth = new ArrayList<Integer>(){{add(1);add(2);add(1);}};
        List<Integer> fifth = new ArrayList<Integer>(){{add(2);add(4);add(5);}};
        List<Integer> sixth = new ArrayList<Integer>(){{add(3);add(5);add(3);}};
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(first);
        input.add(seconde);
        input.add(third);
        input.add(forth);
        input.add(fifth);
        input.add(sixth);
        FindInterestedUsers f = new FindInterestedUsers();
        List<Integer> result = f.findInterestUser(input);
        System.out.println(result);
    }
}

package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class TravelBuddy{
    class Buddy implements Comparable<Buddy>{
        int id;
        double similerNum;
        ArrayList<String> cities;

        public Buddy(int id, double similerNum, ArrayList<String> cities){
            this.id = id;
            this.similerNum = similerNum;
            this.cities = cities;
        }

        @Override
        public int compareTo(Buddy b) {
            if (this.similerNum > b.similerNum) return -1;
            if (this.similerNum < b.similerNum) return 1;
            else return 0;
        }
    }

    public class Solution{

        List<Buddy> buddies = new ArrayList<>();
        ArrayList<String> mycities = new ArrayList<>();
        public List<Integer> Solution(ArrayList<String> myWishList, ArrayList<ArrayList<String>> wishList){
            mycities = myWishList;
            //myWishList put into a hashSet
            HashSet<String> myList = new HashSet<>();
            for(int i = 0; i < myWishList.size(); i++){
                myList.add(myWishList.get(i));
            }


            for(int i = 0; i< wishList.size(); i++){
                int count = 0;
                for(int j = 0; j< wishList.get(i).size(); j++){
                    if(myList.contains(wishList.get(i).get(j))){
                        count++;
                    }
                }
                //How to make this double
                double accurate = ((double)count)/wishList.get(i).size();
                if( accurate >= 0.5){
                    buddies.add(new Buddy(i, accurate,wishList.get(i)));
                }

            }

            //sort buddy List
            Collections.sort(buddies);
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < buddies.size(); i++){
                result.add(buddies.get(i).id);
            }

            return result;
        }

        public List<String> recommendCities(int k) {
            List<String> result = new ArrayList<>();
            for(int i = 0; i< buddies.size() && k>0;i++){
                ArrayList<String> buddyCity = buddies.get(i).cities;
                buddyCity.removeAll(mycities);
                if(buddyCity.size()<=k){
                    result.addAll(buddyCity);
                    k = k-buddyCity.size();
                } else{
                    for(int j = 0; j<buddyCity.size() && k>0;j++){
                        result.add(buddyCity.get(j));
                        k--;
                    }
                }
            }

            return result;
        }




    }
}

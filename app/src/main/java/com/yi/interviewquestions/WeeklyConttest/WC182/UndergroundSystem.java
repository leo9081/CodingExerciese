package com.yi.interviewquestions.WeeklyConttest.WC182;

import java.util.HashMap;

public class UndergroundSystem {

    class Customer{
        int id;
        String startSation;
        int startTime;

        public Customer(int id, String stationName, int t){
            this.id = id;
            this.startSation = stationName;
            this.startTime = t;
        }
    }

    class AvTime{
        int duration = 0;
        int counts = 0;

        public AvTime(int t, int counts){
            this.duration = t;
            this.counts = counts;
        }

    }

    HashMap<String, AvTime> avh;
    HashMap<Integer, Customer> cuh;

    public UndergroundSystem() {
        avh = new HashMap<>();
        cuh = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Customer c = new Customer(id, stationName, t);
        cuh.put(id,c);
    }

    public void checkOut(int id, String stationName, int t) {
        if(!cuh.containsKey(id)){
            return;
        }

        Customer c = cuh.get(id);
        String temp = c.startSation+"_" + stationName;
        if(avh.containsKey(temp)){
            AvTime av = avh.get(temp);
            av.duration = av.duration + t-c.startTime;
            av.counts++;
            avh.put(temp,av);
        }else{
            AvTime av = new AvTime(t-c.startTime, 1);
            avh.put(temp,av);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String temp = startStation+ "_" + endStation;
        if(!avh.containsKey(temp)){
            return 0.0;
        }

        AvTime av = avh.get(temp);

        return (double)av.duration/av.counts;
    }

}

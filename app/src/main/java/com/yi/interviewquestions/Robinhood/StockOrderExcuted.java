package com.yi.interviewquestions.Robinhood;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class StockOrderExcuted {
    static class Order{
        int price;
        int share;
        String action;
        public Order(int price, int share, String action) {
            this.price = price;
            this.share = share;
            this.action = action;
        }
    }

    static class minPQcompare implements Comparator<Order>{

        @Override
        public int compare(Order o1, Order o2) {
            return o1.price - o2.price;
        }
    }

    static class maxPQcompare implements Comparator<Order>{

        @Override
        public int compare(Order o1, Order o2) {
            return o2.price - o1.price;
        }
    }


    public static int ExcutedShare(List<Order> inputs){

        PriorityQueue<Order> minHeap = new PriorityQueue<>(inputs.size(),new minPQcompare());
        PriorityQueue<Order> maxHeap = new PriorityQueue<>(inputs.size(),new maxPQcompare());
        int result = 0;
        for(Order o: inputs){
            if (o.action.equals("buy")) {
                maxHeap.add(o);
            } else {
                minHeap.add(o);
            }
        }

        while(!maxHeap.isEmpty() && !minHeap.isEmpty()){
            Order buyOrder = maxHeap.element();
            if(buyOrder.price > minHeap.peek().price){
                Order saleOrder = minHeap.element();

                if(saleOrder.share == buyOrder.share) {
                    result += buyOrder.share;
                    maxHeap.poll();minHeap.poll();
                }else if(saleOrder.share > buyOrder.share){
                    result += buyOrder.share;
                    saleOrder.share -= buyOrder.share;
                    maxHeap.poll();
                }else{
                    result += saleOrder.share;
                    buyOrder.share -= saleOrder.share;
                    minHeap.poll();
                }
            }else{
                maxHeap.poll();
            }
        }

        return result;
    }

    /*
[150，10， "buy"],
[160，7， "sell"],
[168，3， "buy"],
[155，5， "sell"],
[166，8， "buy"]
 */
    public static void main(String[] args) {
        List<Order> l = new ArrayList<>();
        Order st = new Order(150, 10,"buy");
        l.add(st);
        st = new Order(160, 7,"sell");
        l.add(st);
        st = new Order(168, 3,"buy");
        l.add(st);
        st = new Order(155, 5,"sell");
        l.add(st);
        st = new Order(166, 8,"buy");
        l.add(st);

        int result = ExcutedShare(l);
        System.out.println(result);
    }
}

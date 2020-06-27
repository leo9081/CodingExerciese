package com.yi.interviewquestions.Robinhood;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StockTransaction {
    static class StockTrans{
        String symbol;
        String side;
        int quantity;
        int price;
        public StockTrans(String symbol, String side, int quantity, int price) {
            this.symbol = symbol;
            this.side = side;
            this.quantity = quantity;
            this.price = price;
        }
    }

    static class Stock{
        String symbol;
        int quantity;
        int capital_gain;
        public Stock(String symbol, int quantity, int capital_gain) {
            this.symbol = symbol;
            this.quantity = quantity;
            this.capital_gain = capital_gain;
        }
    }

    //FIFO
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Stock> getStockTransaction(List<StockTrans> inputs){
        HashMap<String, Queue<StockTrans>> hm = new HashMap<String, Queue<StockTrans>>();
        List<Stock> result = new ArrayList<>();
        for(StockTrans s: inputs){
            String name = s.symbol;

            if(hm.containsKey(name)){
                Queue<StockTrans> stocks = hm.get(name);
                if(s.side.equals("sell")){
                    while(!stocks.isEmpty() && s.quantity > 0) {
                        StockTrans st = stocks.peek();
                        if (st.quantity == s.quantity) {
                            result.add(new Stock(s.symbol, s.quantity,
                                    (s.price - st.price) * s.quantity));
                            stocks.poll();
                            break;
                        } else if (st.quantity > s.quantity) {
                            result.add(new Stock(s.symbol, s.quantity,
                                    (s.price - st.price) * s.quantity));
                            st.quantity -= s.quantity;
                            s.quantity = 0;
                        } else {
                            result.add(new Stock(s.symbol, st.quantity,
                                    (s.price - st.price) * st.quantity));
                            s.quantity -= st.quantity;
                            stocks.poll();
                        }

                    }
                }else if(s.side.equals("buy")){
                    stocks.offer(s);
                }
            }else{
                if(!s.side.equals("sell")) {
                    Queue<StockTrans> stocks = new LinkedList<>();
                    stocks.offer(s);
                    hm.put(name,stocks);
                }
            }
        }
        return result;
    }


    //如果不用FIFO，每一个sell match之前最低的价格来maximize capital gain
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Stock> getMaxStockTransaction(List<StockTrans> inputs){
        HashMap<String, PriorityQueue<StockTrans>> hm = new HashMap<String, PriorityQueue<StockTrans>>();
        List<Stock> result = new ArrayList<>();
        for(StockTrans s: inputs){
            String name = s.symbol;

            if(hm.containsKey(name)){
                Queue<StockTrans> stocks = hm.get(name);
                if(s.side.equals("sell")){
                    while(!stocks.isEmpty() && s.quantity > 0) {
                        StockTrans st = stocks.element();
                        if (st.quantity == s.quantity) {
                            result.add(new Stock(s.symbol, s.quantity,
                                    (s.price - st.price) * s.quantity));
                            stocks.poll();
                            break;
                        } else if (st.quantity > s.quantity) {
                            result.add(new Stock(s.symbol, s.quantity,
                                    (s.price - st.price) * s.quantity));
                            st.quantity -= s.quantity;
                            s.quantity = 0;
                        } else {
                            result.add(new Stock(s.symbol, st.quantity,
                                    (s.price - st.price) * st.quantity));
                            s.quantity -= st.quantity;
                            stocks.poll();
                        }

                    }
                }else if(s.side.equals("buy")){
                    stocks.offer(s);
                }
            }else{
                if(!s.side.equals("sell")) {
                    PriorityQueue<StockTrans> stocks = new PriorityQueue<>(10, new pqCompare());
                    stocks.offer(s);
                    hm.put(name,stocks);
                }
            }
        }
        return result;
    }

    static class pqCompare implements Comparator<StockTrans>{

        @Override
        public int compare(StockTrans o1, StockTrans o2) {
            return o1.price - o2.price;
        }
    }

    /*
    [ {‘symbol’: ‘FB’, ‘side’: ‘buy’, ‘quantity’: 1, ‘price’: 200},
{‘symbol’: ‘AAPL’, ‘side’: ‘buy’, ‘quantity’: 1, ‘price’: 100},
{‘symbol’: ‘FB’, ‘side’: ‘sell’, ‘quantity’: 1, ‘price’: 150},
{‘symbol’: ‘AAPL’, ‘side’: ‘buy’, ‘quantity’: 1, ‘price’: 200},
{‘symbol’: ‘AAPL’, ‘side’: ‘buy’, ‘quantity’: 4, ‘price’: 150},
{‘symbol’: ‘AAPL’, ‘side’: ‘sell’, ‘quantity’: 1, ‘price’: 210},
{‘symbol’: ‘AAPL’, ‘side’: ‘sell’, ‘quantity’: 4, ‘price’: 220},
]
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        List<StockTrans> l = new ArrayList<>();
        StockTrans st = new StockTrans("FB", "buy",1, 200);
        l.add(st);
        st = new StockTrans("AAPL", "buy",1, 100);
        l.add(st);
        st = new StockTrans("FB", "sell",1, 150);
        l.add(st);
        st = new StockTrans("AAPL", "buy",1, 200);
        l.add(st);
        st = new StockTrans("AAPL", "buy",4, 150);
        l.add(st);
        st = new StockTrans("AAPL", "sell",4, 210);
        l.add(st);
        st = new StockTrans("AAPL", "sell",1, 220);
        l.add(st);

        List<Stock> result = getMaxStockTransaction(l);
        for(Stock s: result) System.out.println(s.symbol+" "+s.capital_gain+ " "+s.quantity);
    }
}

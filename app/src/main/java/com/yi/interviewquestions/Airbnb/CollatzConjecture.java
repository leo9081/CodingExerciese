package com.yi.interviewquestions.Airbnb;

import java.util.HashMap;
import java.util.Map;

public class CollatzConjecture {

    public class solution{

        public int CollatzConjectureStep(int n){
            int count = 0;
            int max = Integer.MIN_VALUE;
            while(n!=1) {
                max = Math.max(max, n);
                if (n % 2 == 0) {
                    n = n / 2;
                    count++;
                } else {
                    n = 3 * n + 1;
                    count++;
                }
            }
            return max;

        }


        Map<Integer, Integer> map = new HashMap<>();
        public int CollatzConjectureStep2(int n){
            if(n==1) return 1;
            if(map.containsKey(n)){
                return map.get(n);
            }
            if(n%2 == 0) {
                n = n/2;
            }
            else {
                n = n*3+1;
            }

            if(map.containsKey(n))return map.get(n)+1;
            int x = CollatzConjectureStep2(n);
            map.put(n,x);
            return x+1;
        }

        public int findLongestSteps(int n){
            if(n<1) return 0;

            int res = 0;
            for(int i = 1; i<=n; i++){
                int t = CollatzConjectureStep2(i);
                map.put(i,t);
                res = Math.max(res,t);
            }

            return res;
        }


    }
}

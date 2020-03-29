package com.yi.interviewquestions.Airbnb;

public class PourWater {

    public int[] pourWater(int[] heights, int V, int K) {

        while(V > 0){
            int left = K-1;
            int right = K+1;
            int cur = K;

            int lowest = K;
            if(left >= 0 && right<heights.length && heights[right] >= heights[left]){
                while(left >= 0 && heights[left]<=heights[cur]){

                    if(heights[left] < heights[lowest]){
                        lowest = left;

                    }
                    cur--;
                    left--;
                }
            }

            cur = K;
            left = K-1;
            right = K+1;

            if(lowest == K){
                if(right < heights.length && left >= 0 && heights[left]>=heights[right]){
                    while(right<heights.length && heights[right]<=heights[cur]){

                        if(heights[right] < heights[lowest]){
                            lowest = right;
                        }
                        cur++;
                        right++;
                    }
                }

            }

            heights[lowest]++;
            V--;
        }

        return heights;
    }
}

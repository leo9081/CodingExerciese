package com.yi.interviewquestions.Facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    class Point{
        int dist;
        int pos;
        public Point(int dist, int pos){
            this.dist = dist;
            this.pos = pos;
        }

    }

    class pComparator implements Comparator<Point> {
        public int compare(Point a, Point b){
            return a.dist - b.dist;
        }
    }


    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> pq = new PriorityQueue<>(points.length, new pComparator());

        for(int i = 0; i < points.length; i++){
            pq.add(new Point(getDistence(points[i]),i));
        }

        int[][] result = new int[K][2];
        int count = 0;
        while(count < K){
            result[count] = points[pq.poll().pos];
            count++;
        }

        return result;
    }

    public int getDistence(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}

package com.yi.interviewquestions.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    boolean[][] traveled;
    int[][] grid;
    int[][] dirc = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int goodCount = 0;
    int badCount = 0;

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        this.grid = grid;
        traveled = new boolean[grid.length][grid[0].length];
        Queue<Point> rotPoint = new LinkedList<>();

        //find all the rotten orange pos
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 2) rotPoint.offer(new Point(i,j));
                if(grid[i][j] == 1) goodCount++;
            }
        }

        if(rotPoint.size() == 0 && goodCount == 0) return 0;

        //bfs with level order.
        int result = bfs(rotPoint);

        if(goodCount > badCount) return -1;

        return result-1;
    }

    public int bfs(Queue<Point> rotPoint){
        int c = 0;
        while(!rotPoint.isEmpty()){
            int size = rotPoint.size();
            c++;
            for(int j = 0 ; j < size; j++){
                Point temp = rotPoint.poll();
                traveled[temp.row][temp.col] = true;

                for(int i = 0; i<dirc.length; i++){

                    int newRow = temp.row + dirc[i][0];
                    int newCol = temp.col + dirc[i][1];

                    if(isVailed(newRow,newCol) && (grid[newRow][newCol] == 1) && !traveled[newRow][newCol]){
                        badCount++;
                        traveled[newRow][newCol] = true;
                        rotPoint.offer(new Point(newRow,newCol));
                    }
                }
            }
        }

        return c;
    }

    public boolean isVailed(int r, int c){
        return r >=0 && r < grid.length && c >=0 && c< grid[0].length;
    }
}

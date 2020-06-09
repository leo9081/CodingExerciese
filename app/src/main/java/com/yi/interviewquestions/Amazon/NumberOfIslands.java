package com.yi.interviewquestions.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    int[][] dirc = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    char[][] grid;
    boolean[][] traveled;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        if(grid == null || grid.length == 0) return 0;

        traveled = new boolean[grid.length][grid[0].length];

        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(!traveled[i][j] && grid[i][j] == '1'){
                    //System.out.println(i + " " +j);
                    traveled[i][j] = true;
                    count++;
                    bfs(new Point(i,j));
                }
            }
        }
        return count;
    }

    class Point{
        int row; int col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(Point start){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Point temp = q.poll();
            traveled[temp.row][temp.col] = true;
            for(int i = 0; i<dirc.length; i++){
                int newR = temp.row + dirc[i][0];
                int newC = temp.col + dirc[i][1];

                if(isValied(newR,newC) && grid[newR][newC] == '1' && !traveled[newR][newC]){
                    q.add(new Point(newR,newC));
                    traveled[newR][newC] = true;
                }

            }
        }
    }

    public boolean isValied(int r, int c){
        return r >=0 && r < grid.length && c >=0 && c < grid[0].length;
    }
}

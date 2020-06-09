package com.yi.interviewquestions.Facebook;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {
    int[][] n  = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] traveled;
    int[][] grid;
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        traveled = new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i = 0 ; i< grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(!traveled[i][j] && grid[i][j] == 1){
                    traveled[i][j] = true;
                    result = bfs(new Point(i,j),traveled);
                    return result;
                }
            }

        }
        return result;
    }

    public int bfs(Point pos,boolean[][] traveled){
        int side = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(pos);
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i = 0; i< n.length; i++){
                int newX = temp.x + n[i][0];
                int newY = temp.y + n[i][1];
                if(isValid(newX,newY) && traveled[newX][newY])continue;

                if(isValid(newX,newY) && grid[newX][newY] == 1){
                    q.offer(new Point(newX,newY));
                    traveled[newX][newY] = true;
                }else{
                    side++;
                }
            }
        }

        return side;
    }

    public boolean isValid(int x, int y){
        return x>=0 && y >=0 && x<grid.length && y < grid[0].length;
    }
}

package com.yi.interviewquestions.ThirtyLeetCodingChallenge;

import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class UnionFind{

    int count;
    int parent[];
    int prioity[];

    public UnionFind(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        prioity = new int[m * n];
        count = 0;

        for(int i = 0; i< m; ++i){
            for (int j = 0; j< n; ++j){
                if(grid[i][j] == '1'){
                    parent[i*n+j] = i*n+j;
                    ++count;
                }
                prioity[i*n+j] = 0;
            }
        }
    }

    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx != rooty) {
            if (prioity[rootx] > prioity[rooty]) {
                parent[rooty] = rootx;
            }else if(prioity[rootx] < prioity[rooty]){
                parent[rootx] = rooty;
            }else{
                parent[rooty] = rootx;
                prioity[rootx] += 1;
            }
            --count;
        }

    }

    public int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }



    public int getCount() {
        return count;
    }

}

public class NumberofIslands {

    Boolean[][] traveled;
    char[][] grid;
    int[][] dirctions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        this.grid = grid;
        traveled = new Boolean[rows][cols];
        int counts = 0;



        //Interesting solution: Union Find

        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    for(int k = 0; k < dirctions.length ;k++){
                        int newi = i + dirctions[k][0];
                        int newj = j + dirctions[k][1];

                        if(isValed(newj,newi) && grid[newi][newj] == '1'){
                            uf.union(i * cols + j, newi * cols + newj);
                        }
                    }
                }
            }
        }

        counts = uf.getCount();

        //normal solution: bfs
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                traveled[i][j] = false;
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !traveled[i][j]){
                    bfs(new Point(j,i));
                    counts++;
                }
            }
        }

        //normal solution: dfs
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    counts++;
                    dfs(new Point(j,i));
                }
            }
        }

        return counts;
    }

    public void dfs(Point p){
        if(!isValed(p.x,p.y) || grid[p.y][p.x] == '0') return;

        grid[p.y][p.x] = '0';
        for(int k = 0; k < dirctions.length ;k++){
            int newy = p.y + dirctions[k][0];
            int newx = p.x + dirctions[k][1];
            dfs(new Point(newx, newy));
        }

    }

    public void bfs(Point start){
        Queue<Point> q = new LinkedList<>();

        q.add(start);
        while(!q.isEmpty()){
            Point temp = q.poll();

            for(int i =0;i<dirctions.length; i++){
                int newx = temp.x+dirctions[i][0];
                int newy = temp.y+dirctions[i][1];

                if(isValed(newx,newy) && !traveled[newy][newx] && grid[newy][newx] == '1'){
                    q.add(new Point(newx, newy));
                    traveled[newy][newx] = true;
                }
            }
        }
    }

    public boolean isValed(int x, int y){
        return (x>=0 && y>=0 && x < grid[0].length && y < grid.length);
    }



    public static void main(String[] args){

    }
}

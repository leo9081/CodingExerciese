package com.yi.interviewquestions.Google;

import java.util.HashSet;
import java.util.Stack;

public class LightOutPuzzle {

    class point{
        int x;
        int y;

        public point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    point[][] p;
    public int solution(int[][] input){

        p = new point[input.length][input[0].length];
        for(int i  = 0; i< input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                p[i][j] = new point(j,i);
            }
        }


        int min = Integer.MAX_VALUE;
        for(int i  = 0; i< input.length; i++){
            for(int j = 0; j< input[i].length; j++) {
                min = Math.min(min, dfs(p[i][j],input));

            }
        }
        return min;
    }


    public int dfs(point c, int[][] input){
        int result = 0;
        Stack<point> s = new Stack<>();
        HashSet<point> h = new HashSet<>();

        s.push(c);
        h.add(c);
        while(!s.isEmpty()){
            point temp = s.pop();
            result++;
            if(input[temp.x][temp.y] == 1) input[temp.x][temp.y] = 0;
            else if(input[temp.x][temp.y] == 0) input[temp.x][temp.y] = 1;

            if(temp.x -1 >=0){
                point pt = p[temp.x-1][temp.y];
                if(input[pt.x][pt.y] == 1) {
                    input[pt.x][pt.y] = 0;
                }else{
                    input[pt.x][pt.y] = 1;
                }
                if(!h.contains(pt)) {
                    s.push(pt);
                    h.add(pt);
                }
            }

            if(temp.x +1 < input[0].length ){
                point pt = p[temp.x+1][temp.y];
                if(input[pt.x][pt.y] == 1) {
                    input[pt.x][pt.y] = 0;
                }else{
                    input[pt.x][pt.y] = 1;
                }
                if(!h.contains(pt)) {
                    s.push(pt);
                    h.add(pt);
                }
            }


            if(temp.y -1 >=0){
                point pt = p[temp.x][temp.y-1];
                if(input[pt.x][pt.y] == 1) {
                    input[pt.x][pt.y] = 0;
                }else{
                    input[pt.x][pt.y] = 1;
                }
                if(!h.contains(pt)) {
                    s.push(pt);
                    h.add(pt);
                }
            }

            if(temp.y +1 < input.length ){
                point pt = p[temp.x][temp.y+1];
                if(input[pt.x][pt.y] == 1) {
                    input[pt.x][pt.y] = 0;
                }else{
                    input[pt.x][pt.y] = 1;
                }
                if(!h.contains(pt)) {
                    s.push(pt);
                    h.add(pt);
                }
            }
        }

        return result;
    }

    public static void main(String[] arg){
        LightOutPuzzle l = new LightOutPuzzle();
        int[][] input = new int[4][4];
        for(int i = 0; i< input.length; i++){
            for(int j = 0; j<input.length;j++){
                input[i][j] = 0;

            }
        }
        int result = l.solution(input);
        System.out.println(result);
    }
}

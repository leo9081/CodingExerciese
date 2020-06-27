package com.yi.interviewquestions.Amazon;

public class WordSearch {
    class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    int[][] dirc = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] travaled;

    public boolean exist(char[][] board, String word) {

        travaled = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length ; i++){
            for(int  j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    travaled = new boolean[board.length][board[0].length];
                    if(dfs(board,word,new Point(i,j), 1)){
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean dfs(char[][] board, String word, Point p, int wordPos){
        if(wordPos >= word.length()){
            return true;
        }

        boolean ret = false;
        travaled[p.row][p.col] = true;

        for(int i = 0 ; i < dirc.length; i++){
            int newRow = p.row + dirc[i][0];
            int newCol= p.col + dirc[i][1];
            if(isVailed(newRow,newCol,board) && !travaled[newRow][newCol] && word.charAt(wordPos) == board[newRow][newCol]){
                ret = dfs(board,word,new Point(newRow,newCol),wordPos+1);
                if(ret) break;

            }
        }
        if(!ret) travaled[p.row][p.col] = false;
        return ret;

    }

    public boolean isVailed(int r, int c,char[][] board){
        return r>=0 && r < board.length && c >=0 && c<board[0].length;
    }

}

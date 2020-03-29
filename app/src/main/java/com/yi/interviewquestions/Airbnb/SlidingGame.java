package com.yi.interviewquestions.Airbnb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlidingGame {

    public SlidingGame(int[][] matrix) {


    }

    class Node{
        String boardString;
        int[][] curBoard;
        int curRow;
        int curCol;
        int steps;

        public Node(int[][] curBoard, int curRow, int curCol, int steps){
            this.curBoard = curBoard;
            boardString = Arrays.deepToString(curBoard);
            this.curRow = curRow;
            this.curCol = curCol;
            this.steps = steps;
        }

    }

    public int slidingPuzzle(int[][] board) {
        int r = board.length-1;
        int c = board[0].length-1;

        int curRow = 0;
        int curCol = 0;
        //find zero;
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j < board[i].length;j++){
                if(board[i][j] == 0){
                    curRow = i;
                    curCol = j;
                    break;
                }
            }
        }
        //create zero state
        Node startNode = new Node(board,curRow,curCol,0);
        //create final board
        String target = Arrays.deepToString(new int[][]{{1,2,3},{4,5,0}});
        int[][] changeVal = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        Queue<Node> q = new LinkedList<>();
        //Hash for boardState;
        HashSet<String> h = new HashSet<>();

        //bfs zero state
        q.offer(startNode);
        h.add(startNode.boardString);

        while(!q.isEmpty()){
            Node temp = q.poll();

            if(temp.boardString.equals(target)){
                return temp.steps;
            }

            for(int i = 0; i< changeVal.length;i++){
                int newRow = temp.curRow + changeVal[i][0];
                int newCol = temp.curCol + changeVal[i][1];

                if(newRow< 0|| newRow > r|| newCol<0||newCol > c){
                    continue;
                }

                int[][] newBoard = new int[r+1][c+1];
                int count = 0;
                for(int[] Row: temp.curBoard){
                    newBoard[count++] =Row.clone();
                }

                newBoard[temp.curRow][temp.curCol] = newBoard[newRow][newCol];
                newBoard[newRow][newCol] =0;

                Node newNode = new Node(newBoard,newRow,newCol,temp.steps+1);
                if(h.contains(newNode.boardString)) continue;

                q.offer(newNode);
                h.add(newNode.boardString);

            }
        }


        return -1;
    }
}

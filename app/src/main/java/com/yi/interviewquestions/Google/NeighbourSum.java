package com.yi.interviewquestions.Google;

public class NeighbourSum {

    public void soution(int[][] input){

        int[][] result = new int[input.length][input.length];

        for(int i = 0; i<input.length; i++){
            for(int j = 0; j< input[i].length; j++) {
                int res = 0;
                if (j > 0) res += input[i][j - 1];
                if (i > 0) res += input[i - 1][j];
                if (i < input.length - 1) res += input[i + 1][j];
                if (j < input[i].length - 1) res += input[i][j + 1];
                result[i][j] = res;
            }
        }

    }

}

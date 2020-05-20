package com.yi.interviewquestions.Facebook;

public class SparseMatrixMultiplication {



    //this is not a good solution, seems SparseMatrix has 3-4 better ways of calculation
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for(int i =0 ; i< A.length; i++){
            for(int col = 0; col < B[0].length; col++){
                for(int j = 0; j< B.length; j++){
                    result[i][col] += A[i][j] * B[j][col];
                }
            }

        }
        return result;
    }
}

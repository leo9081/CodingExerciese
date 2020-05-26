package com.yi.interviewquestions.Facebook;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {

    //Simulation
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int dir = 1;//1:up 2:down
        int col = 0;
        int row = 0;
        int colBound = matrix[0].length - 1;
        int rowBound = matrix.length - 1;

        List<Integer> a = new ArrayList<>();

        while (row <= rowBound && col <= colBound) {
            if (dir % 2 != 0) {
                while (col <= colBound && row <= rowBound && col >= 0 && row >= 0) {
                    a.add(matrix[row][col]);
                    col++;
                    row--;
                }
                row++;
            } else {
                while (col <= colBound && row <= rowBound && col >= 0 && row >= 0) {
                    a.add(matrix[row][col]);
                    col--;
                    row++;
                }
                col++;
            }

            if (row >= rowBound && col >= colBound) {
                if (row == rowBound && col == colBound) {
                    a.add(matrix[row][col]);
                }
                break;
            } else if (row > rowBound) {
                row--;
                col++;

            } else if (col > colBound) {
                col--;
                row++;
            }
            dir++;

        }

        int[] r = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            r[i] = a.get(i);
        }

        return r;
    }
}

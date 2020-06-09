package com.yi.interviewquestions.Amazon;

public class SkiProblem {
    /*
    滑雪问题, 一个二维数组 mxn，0表示可以滑，1表示有树不能滑。只能往右或者往下滑，判断从顶点(0,0)位置能不能滑到数组最右下(m,n)。
    函数返回true/false. 不能修改原数组
[
  [0,0,1]
  [0,0,0]
  [0,1,0]
]
     */

    public boolean skirout(int[][] input){

        boolean[][] f = new boolean[input.length][input[0].length];

        //initial boundary
        for(int i = 0; i < input.length; i++){
            f[i][0] = (input[i][0] == 0);
        }

        for(int j = 0; j< input.length; j++){
            f[0][j] = (input[0][j] == 0);
        }

        for(int i = 1; i < input.length; i++){
            for(int j = 1; j< input.length; j++){
                //f[i][j] = f[i-1][j] || f[i][j-1];
                if(input[i][j]== 1)f[i][j] =false;
                else f[i][j] = f[i-1][j] || f[i][j-1];
            }
        }


        return f[input.length-1][input[0].length-1];
    }

    public static void main(String[] arg){
        int[] line1 = new int[]{0,0,1};
        int[] line2 = new int[]{0,0,1};
        int[] line3 = new int[]{0,1,0};

        int[][] input = new int[][]{line1,line2,line3};
        SkiProblem sk = new SkiProblem();
        System.out.println(sk.skirout(input));
    }
}

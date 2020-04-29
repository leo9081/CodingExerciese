package com.yi.interviewquestions.ThirtyLeetCodingChallenge

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *     fun get(row:Int, col:Int):Int {}
 *     fun dimensions():List<Int> {}
 * }
 */

class BinaryMatrix {
    var arr = Array(5, {IntArray(5)})
    constructor(arr:Array<IntArray>){this.arr = arr};
    fun get(row:Int, col:Int):Int {return arr[row][col]}
    fun dimensions():List<Int> {return listOf(arr.size, arr[0].size)}
}

class Solution {

    fun leftMostColumnWithOne(binaryMatrix:BinaryMatrix):Int {

        //this.binaryMatrix = binaryMatrix;

        var start = 0;
        var end = binaryMatrix.dimensions()[1]-1;

        while(start + 1 < end){
            var mid = start + (end - start)/2;
            if(binSearchInCol(mid,binaryMatrix)) end = mid;
            else start = mid;
        }

        if(binSearchInCol(start,binaryMatrix)) return start;
        if(binSearchInCol(end,binaryMatrix)) return end;

        return -1;
    }

    fun binSearchInCol(col: Int, binaryMatrix:BinaryMatrix):Boolean{
        var start = 0;
        var end = binaryMatrix.dimensions()[0];

        while(start < end){

            if(binaryMatrix.get(start, col) == 1) return true;

            start++;
        }

        return false;
    }

}

fun main(args: Array<String>) {
    var arr = arrayOf(intArrayOf(1,1,1,1,1,1),intArrayOf(0,0,0,1,0,1));
    var b = BinaryMatrix(arr);
    var s = Solution();
    var r = s.leftMostColumnWithOne(b)
    System.out.println(r);
}
/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] h = new int[m][n];
        for(int row =0; row<m;row++){
            for(int col =0; col<n;col++){
                max = Math.max(max,maxIncrease(matrix,h,row+1,col,matrix[row][col])+1);
                max = Math.max(max,maxIncrease(matrix,h,row,col+1,matrix[row][col])+1);
                max = Math.max(max,maxIncrease(matrix,h,row-1,col,matrix[row][col])+1);
                max = Math.max(max,maxIncrease(matrix,h,row,col-1,matrix[row][col])+1);
            }
        }
        return max;
    }
    
    public int maxIncrease(int[][] m, int[][] h, int row, int col, int lastval){
        if(row<0||row>=m.length||col<0||col>=m[0].length||m[row][col]>=lastval){
            return 0;
        }
        if(h[row][col] ==0){
            h[row][col] = maxIncrease(m,h,row+1,col,m[row][col])+1;
            h[row][col] = Math.max(h[row][col],maxIncrease(m,h,row,col+1,m[row][col])+1);
            h[row][col] = Math.max(h[row][col],maxIncrease(m,h,row,col-1,m[row][col])+1);
            h[row][col] = Math.max(h[row][col],maxIncrease(m,h,row-1,col,m[row][col])+1);
        }
        return h[row][col];
    }
}
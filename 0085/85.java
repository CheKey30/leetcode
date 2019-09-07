/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] grid = new int[rows][cols];
        buildgrid(matrix,grid);
        int max = 0;
        for(int i=0;i<rows;i++){
            max = Math.max(max,findmax(grid[i]));
        }
        return max;
    }
    
    public void buildgrid(char[][] matrix, int[][] grid){
        for(int i=0;i<matrix[0].length;i++){
            grid[0][i] = matrix[0][i]=='1'?1:0;
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                grid[i][j] = matrix[i][j]=='1'?grid[i-1][j]+1:0;
            }
        }
    }
    
    public int findmax(int[] grid){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res=0;
        for(int i=0;i<grid.length;i++){
            while(stack.peek()!=-1 && grid[i]<grid[stack.peek()]){
                int index = stack.pop();
                res = Math.max(res,grid[index]*(i-1-stack.peek()));
            }
            stack.add(i);
        }
        while(stack.peek()!=-1){
            int index = stack.pop();
            res = Math.max(res,grid[index]*(grid.length-1-stack.peek()));
        }
        return res;
    }
}
/*

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        for(int i=0;i<rows;i++){
            for(int j=0; j<cols;j++){
                    if(i-1>=0 && j-1>=0){
                        if(matrix[i][j]=='0'){
                            dp[i][j]=0;
                        }else{
                            dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                        }
                        
                    }else{
                        dp[i][j] = matrix[i][j]-48;
                    }
                max = Math.max(max,dp[i][j]);
                }
            }
        
        // for(int[] x:dp){
        //     for(int y:x){
        //         System.out.print(y+" ");
        //     }
        //     System.out.println();
        // }
        return max*max;
        }
}
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

class Solution {
   public boolean exist(char[][] board, String word) {
        if(board.length==0 || board[0].length==0){
            return false;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(dfs(board,visited,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int i, int j,int index,String word){
        if(index==word.length()){
            return true;
        }
        if(i<0 || j<0|| i>=board.length || j>=board[0].length || visited[i][j] ||board[i][j] != word.charAt(index)){
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board,visited, i-1,j,index+1,word)
                ||dfs(board,visited, i+1,j,index+1,word)
                ||dfs(board,visited, i,j-1,index+1,word)
                ||dfs(board,visited, i,j+1,index+1,word);
        visited[i][j] = false;
        return res;
    }
}
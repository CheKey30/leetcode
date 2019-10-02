/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
*/

class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length !=9 || board[0].length != 9 ){
            return;
        }
        solve(board,0,0);
    }
    
    public boolean solve(char[][] board,int row, int col){
        if(row==9){
            return true;
        }
        if(col>=9){
            return solve(board,row+1,0);
        }
        
        if(board[row][col] !='.'){
            return solve(board,row,col+1);
        }
        for(char c = '1';c<='9';c++){
            if(!isvalid(board,row,col,c)){
                continue;
            }
            board[row][col]=c;
            if(solve(board,row,col+1)){
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }
    
    public boolean isvalid(char[][] board, int row, int col, char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[row][i]==c){
                return false;
            }
        }
        int i = row-row%3;
        int j = col-col%3;
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                if(board[x+i][y+j]==c){
                    return false;
                }
            }
        } 
        return true;
    }
    
}
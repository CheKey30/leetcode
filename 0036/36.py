```
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
```

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if len(board)!=9 or len(board[0])!=9:
            return False
        row =set()
        for i in range(9):
            for j in range(9):
                if board[i][j] != "." and board[i][j] in row:
                    return False
                if board[i][j] !=".":
                    row.add(board[i][j])
            row.clear()
        
        for i in range(9):
            for j in range(9):
                if board[j][i] !="." and board[j][i] in row:
                    return False
                if board[j][i] !=".":
                    row.add(board[j][i])
            row.clear()
        
        for i in range(0,3):
            for j in range(0,3):
                for k in range(i*3,i*3+3):
                    for l in range(j*3,j*3+3):
                        if board[k][l] !="." and board[k][l] in row:
                            return False
                        if board[k][l] !=".":
                            row.add(board[k][l])
                row.clear()
        return True
                
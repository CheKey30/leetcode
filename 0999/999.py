```
On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.

The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.

 

Example 1:



Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation: 
In this example the rook is able to capture all the pawns.
Example 2:



Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 0
Explanation: 
Bishops are blocking the rook to capture any pawn.
Example 3:



Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation: 
The rook can capture the pawns at positions b5, d6 and f5.
```
class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        m = len(board)
        n = len(board[0])
        col=row=0
        for i in range(n):
            for j in range(m):
                if board[j][i]=="R":
                    col = i
                    row = j
                    break
            if col !=0:
                break
                
        ##print(col,row)
        count = 0
        u,d = row,row
        while u>=0 or d<m:
           ## print(u,d)
            if u>=0 and board[u][col]=="p":
                count+=1
                u = -1
            if d<m and board[d][col]=="p":
                count+=1
                d = m
            if u>=0 and board[u][col]=="B":
                u = -1
            if d<m and board[d][col]=="B":
                d=m
            u-=1
            d+=1
        l,r = col,col
        while l>=0 or r<n:
            if l>=0 and board[row][l]=="p":
                count+=1
                l = -1
            if r<m and board[row][r]=="p":
                count+=1
                r = n
            if l>=0 and board[row][l]=="B":
                l=-1
            if r<m and board[row][r]=="B":
                r=n
            l-=1
            r+=1
        return count
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0){
            return 0;
        }
        int m =grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    mark(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void mark(char[][] grid, boolean[][] visited, int x, int y){
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0' || visited[x][y]) return;
            visited[x][y] = true;
            mark(grid,visited,x + 1, y);
            mark(grid,visited,x - 1, y);
            mark(grid,visited,x, y + 1);
            mark(grid,visited,x, y - 1);
    }
    
}
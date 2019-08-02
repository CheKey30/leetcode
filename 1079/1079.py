```
You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.

 

Example 1:

Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: "AAABBC"
Output: 188
 

Note:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.
```
class Solution(object):
    def numTilePossibilities(self, tiles):
        """
        :type tiles: str
        :rtype: int
        """
        def backtrack(s,visited,curr,res):
            if curr not in res and curr !="":
                res.add(curr)
            for i in range(len(s)):
                if visited[i]== False:
                    visited[i] = True
                    curr+=s[i]
                    backtrack(s,visited,curr,res)
                    curr = curr[:-1]
                    visited[i] = False
        res = set()
        curr = ""
        visited = [False]*len(tiles)
        backtrack(tiles,visited,curr,res)
        return len(res)
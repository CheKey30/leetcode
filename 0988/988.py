```
Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

 

Example 1:



Input: [0,1,2,3,4,3,4]
Output: "dba"
Example 2:



Input: [25,1,3,1,3,0,2]
Output: "adz"
```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def smallestFromLeaf(self, root: TreeNode) -> str:
        def dfs(root,res,path):
            if not root.left and not root.right:
                if not res[0]:
                    res[0] = (path+chr(ord('a')+root.val))[::-1]
                else:
                    res[0] = min(res[0],(path+chr(ord('a')+root.val))[::-1])
            if root.left:
                dfs(root.left,res,path+chr(ord('a')+root.val))
            if root.right:
                dfs(root.right,res,path+chr(ord('a')+root.val))
        if not root:
            return ""
        res =[""]
        path=""
        dfs(root,res,path)
        return res[0]
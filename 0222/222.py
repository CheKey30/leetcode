```
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def countNodes(self, root: TreeNode) -> int:
        def countNode(root):
            hleft = hright =0
            l=r=root
            while l:
                hleft+=1
                l=l.left
            while r:
                hright +=1
                r = r.right
            if hleft ==hright:
                return pow(2,hleft)-1
            return countNode(root.left)+countNode(root.right)+1
        return countNode(root)
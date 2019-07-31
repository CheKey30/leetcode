```
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        queue = []
        res = []
        queue.append(root)
        last=nlast=root
        while queue:
            root = queue.pop(0)
            if root.left:
                queue.append(root.left)
                last = queue[-1]
            if root.right:
                queue.append(root.right)
                last = queue[-1]
            if root == nlast:
                res.append(root.val)
                nlast = last
        return res
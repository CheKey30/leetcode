```
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def preorder(root,res):
            if root:
                res.append(root)
                preorder(root.left,res)
                preorder(root.right,res)
        tmp = []
        if not root:
            return 
        preorder(root,tmp)
        n = len(tmp)
        for i in range(n-1):
            tmp[i].left = None
            tmp[i].right = tmp[i+1]
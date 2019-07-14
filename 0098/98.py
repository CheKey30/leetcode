```
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
```
### s1:
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def isvalid(root,min_val,max_val):
            if not root:
                return True
            if root.val<=min_val or root.val>=max_val:
                return False
            return isvalid(root.left,min_val,root.val) and isvalid(root.right,root.val,max_val)
        return isvalid(root,-float("inf"),float("inf"))
		
### s2:
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        res = []
        def preorder(root):
            if root:
                preorder(root.left)
                res.append(root.val)
                preorder(root.right)
        preorder(root)
        for i in range(1,len(res)):
            if res[i]>res[i-1]:
                continue
            else:
                return False
        return True
        


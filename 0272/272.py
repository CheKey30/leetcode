```
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]
```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def closestKValues(self, root: TreeNode, target: float, k: int) -> List[int]:
        def inorder(root,target,k,stock):
            if not root:
                return
            inorder(root.left,target,k,stock)
            if len(stock)<k:
                stock.append(root.val)
            elif abs(stock[0]-target)>abs(root.val-target):
                stock.append(root.val)
                stock.pop(0)
            inorder(root.right,target,k,stock)
        stock = []
        inorder(root,target,k,stock)
        return stock
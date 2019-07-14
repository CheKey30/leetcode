```
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
```

### s1 O(nlogn):
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        def height(root):
            if not root:
                return 0
            return max(height(root.left),height(root.right))+1
        def isbalanced(root):
            if not root:
                return True
            left = height(root.left)
            right = height(root.right)
            return abs(right-left)<=1 and isbalanced(root.left) and isbalanced(root.right)
        return isbalanced(root)
### s2 O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    balance = True
    def isBalanced(self, root: TreeNode) -> bool:
        def height(self,root):
            if not root:
                return 0
            left = height(self,root.left)
            right = height(self,root.right)
            if abs(left-right)>1:
                self.balance = False
                return -1
            return max(left, right)+1
        height(self,root)
        return self.balance
        
	
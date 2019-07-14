```
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        queue = []
        queue.append(root)
        last = nlast = root
        tmp = set()
        while queue:
            node = queue.pop(0)
            if node.left:
                queue.append(node.left)
                nlast = node.left
            if node.right:
                queue.append(node.right)
                nlast = node.right
            if node.left and node.right:
                if node.left.val in {x,y} and node.right.val in {x,y}:
                    return False
            tmp.add(node.val)
            if node == last:
                print(tmp)
                if x in tmp and y in tmp:
                    return True
                tmp.clear()
                last = nlast
        return False
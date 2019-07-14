```
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        queue = []
        queue.append(root)
        last = nlast = root
        count = 0
        tmp=[]
        res = []
        while queue:
            node = queue.pop(0)
            if node.left:
                queue.append(node.left)
                nlast = queue[-1]
            if node.right:
                queue.append(node.right)
                nlast = queue[-1]
            tmp.append(node.val)
            if node==last:
                if count %2==0:
                    res.append(tmp)
                else:
                    res.append(tmp[::-1])
                tmp = []
                count+=1
                last = nlast
        return res
                
            
                
                
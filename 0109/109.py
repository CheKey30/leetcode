```
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 ```
 # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        tmp =[]
        while head:
            tmp.append(head.val)
            head = head.next
        if not tmp:
            return
        def atb(tmp,start,end):
            if start>end:
                return
            mid = (start+end)//2
            root = TreeNode(tmp[mid])
            root.left = atb(tmp,start,mid-1)
            root.right = atb(tmp,mid+1,end)
            return root
        return atb(tmp,0,len(tmp)-1)
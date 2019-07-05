```
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
```
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        bef=[]
        aft=[]
        tmp = head
        while tmp:
            if tmp.val<x:
                bef.append(tmp.val)
            else:
                aft.append(tmp.val)
            tmp = tmp.next
        if bef and aft:
            res = ListNode(bef.pop(0))
            tmp2 = res
            while bef:
                tmp2.next = ListNode(bef.pop(0))
                tmp2 = tmp2.next
            while aft:
                tmp2.next = ListNode(aft.pop(0))
                tmp2 = tmp2.next
            return res
        else:
            return head
            
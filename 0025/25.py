```
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
```
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if(not head or not head.next or k==1):
            return head
        cur = head
        count = 0
        while cur and count !=k:
            cur = cur.next
            count +=1
        if count == k:
            cur = self.reverseKGroup(cur,k)
            while count>0:
                count-=1
                tmp = head.next
                head.next = cur
                cur = head
                head = tmp
            head = cur
        return head
            
                
```
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
```
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        def sortedMerge(node1,node2):
            if node1 == None:
                return node2
            if node2 == None:
                return node1
            if node1.val <= node2.val:
                res = node1
                res.next = sortedMerge(node1.next,node2)
            else:
                res = node2
                res.next = sortedMerge(node1,node2.next)
            return res
        def getMiddle(head):
            if head == None:
                return head
            fastptr = head.next
            slowptr = head
            while fastptr != None:
                fastptr = fastptr.next
                if fastptr !=None:
                    slowptr = slowptr.next
                    fastptr = fastptr.next
            return slowptr
        def mergeSort(head):
            if head == None or head.next ==None:
                return head
            mid = getMiddle(head)
            midnext = mid.next
            mid.next = None
            left = mergeSort(head)
            right = mergeSort(midnext)
            sortedlist = sortedMerge(left,right)
            return sortedlist
        return mergeSort(head)
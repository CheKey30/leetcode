/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int next = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 !=null || l2 != null){
            sum = (l1 != null ? l1.val:0) + (l2 != null ? l2.val:0) + next;
            next = sum/10;
            sum = sum %10;
            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;
            l1 = l1==null? null:l1.next;
            l2 = l2==null? null:l2.next;
        }
        if(next !=0){
            ListNode node = new ListNode(next);
            p.next = node;
        }
        return head.next;
    }
}
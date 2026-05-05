/* 
Leetcode : 61
https://leetcode.com/problems/rotate-list/description/
*/




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        //compute the length of the linked list
        int len = 1; 
        ListNode curr = head;
        while(curr.next != null) { // stop at last node
            curr = curr.next;
            len++;
        }

        //point the last node to head
        curr.next = head;

        k = k % len;
        k = len - k;

        while(k > 0) {
            curr = curr.next;
            k--;
        }
        head = curr.next;
        curr.next = null;

        return head;
    }
}
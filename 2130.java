/* 
Leetcode : 2130
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
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


//Approach 1:
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;
        int max = 0;
        while(i < j) {
            max = Math.max(max, list.get(i) + list.get(j));
            i++;
            j--;
        }

        return max;
    }
}






//Approach 2:
class Solution {
    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode curr = head;

        while(curr != null) {
            st.push(curr.val);
            curr = curr.next;
        }

        curr = head;
        int n = st.size();
        int max = 0;
        int count = 1;

        while(count <= n/2) {
            max = Math.max(max, curr.val + st.pop());
            curr = curr.next;
            count++;
        }

        return max;
    }
}








//Approach 3:
class Solution {
    public int pairSum(ListNode head) {
        ListNode mid = null;

        ListNode slow = head;
        ListNode fast = head;

        //find middle
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;

        //reverse second half
        ListNode next = null;
        ListNode prev = null;

        while(mid != null) {
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }


        //max sum
        ListNode curr = head;
        int max = 0;
        while(prev != null) {
            max = Math.max(max, curr.val + prev.val);
            curr = curr.next;
            prev = prev.next;
        }

        return max;
    }
}

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

// Time: O(max(l1, l2))
// Space: O(max(l1, l2))
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        
        ListNode p = l1;
        ListNode q = l2;
        
        int carry = 0;
        while (p != null || q != null) {
            int sum = 0;
            
            if (p != null)
                sum += p.val;
            
            if (q != null)
                sum += q.val;
            
            sum += carry;
            carry = sum / 10;
            sum %= 10;
            
            head.next = new ListNode(sum);
            head = head.next;
            
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        
        if (carry > 0)
            head.next = new ListNode(carry);
        
        return result.next;
    }
}

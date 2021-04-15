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
// Time: O(n)
// Space: O(1)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) 
            return head;
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        
        ListNode oddNode = oddHead;
        ListNode evenNode = evenHead;
        
        ListNode current = head.next.next;
        while (current != null) {
            oddNode.next = current;
            oddNode = oddNode.next;
            current = current.next;
            
            evenNode.next = current;
            evenNode = evenNode.next;
            if (current != null) current = current.next;
        }
        
        oddNode.next = evenHead;
        
        return oddHead;
    }
}
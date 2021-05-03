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

// n = total number of nodes
// k = number of linked lists in lists[]
// Time: O(n log k)
// Space: O(n)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null)
                minHeap.offer(list);
        }
        if (minHeap.size() == 0) return null;
        
        ListNode result = new ListNode();
        ListNode head = result;
        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            
            head.val = curr.val;
            if (curr.next == null && minHeap.isEmpty()) break;
            head.next = new ListNode();
            head = head.next;
            
            curr = curr.next;
            if (curr != null) minHeap.offer(curr);
        }
        
        return result;
    }
}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p= l1; ListNode q= l2;
        ListNode curr= result;
        int carry=0;
        
        while(p!= null || q!= null) {
            int x=0;
            int y=0;
            
            if(p!= null)
                x= p.val;
            else
                x=0;
            
            if(q!= null)
                y= q.val;
            else
                y=0;
            
            int sum = x+y+carry;
            carry= sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            
            if(p!=null)
                p=p.next;
            if(q!=null)
                q=q.next;
     
        }
 
        if(carry>0)
            curr.next= new ListNode(carry);
 
        return result.next;
    }
}
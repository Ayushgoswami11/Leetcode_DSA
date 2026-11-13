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
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode f=null;

        while(curr!=null){
            f=curr.next;
            curr.next=prev;
            prev=curr;
            curr=f;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        int max=Integer.MIN_VALUE;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head1=slow.next;
        slow.next=null;
        head1=reverse(head1);
        ListNode i=head;
        ListNode j=head1;
        int curr=0;
        while(j!=null){
            curr=i.val + j.val;
            max=Math.max(curr,max);
            i=i.next;
            j=j.next;
        }
        return max;
        
        
    }
}
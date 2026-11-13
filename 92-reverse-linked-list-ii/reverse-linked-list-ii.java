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
     public static void reverse(ListNode head){
            ListNode prev=null;
            ListNode forw=null;
            ListNode curr=head;

            while(curr!=null){
                forw=curr.next;
                curr.next=prev;
                prev=curr;
                curr=forw;
            }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) return head;

        ListNode dummy=new ListNode(0,head);
        ListNode temp=dummy;

        for(int i=1;i<left;i++){
            temp=temp.next;
        }
        ListNode tail1=temp;
        ListNode head1=temp.next;

        for(int i=0;i<right-left+1;i++){
            temp=temp.next;
        }
        ListNode tail2=temp;
        ListNode head2=temp.next;

        tail1.next=null;
        tail2.next=null;

        reverse(head1);
        tail1.next=tail2;
        head1.next=head2;

        return dummy.next;
    }
}
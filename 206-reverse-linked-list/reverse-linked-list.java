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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Save the next node
            curr.next = prev;              // 2. Reverse the pointer
            prev = curr;                   // 3. Move 'prev' one step forward
            curr = nextTemp;               // 4. Move 'curr' one step forward
        }
        
        // At the end, 'prev' will be pointing to the new head of the reversed list
        return prev;
    }
}
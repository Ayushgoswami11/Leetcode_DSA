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
        ListNode dummy = new ListNode(0); // Dummy head anchor
        ListNode curr = dummy;            // Pointer to track our position in the result list
        int carry = 0;                    // Variable to track arithmetic carry-over
        
        // Keep looping as long as there are digits left in either list OR a remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Calculate sum and update carry
            int currentSum = val1 + val2 + carry;
            carry = currentSum / 10;
            
            // Create the next node in the result chain
            curr.next = new ListNode(currentSum % 10);
            curr = curr.next; // Move result pointer forward
            
            // Advance input pointers if they have more digits
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}
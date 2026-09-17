/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Step 1: Copy the value of the next node into the current node
        node.val = node.next.val;

        // Step 2: Skip the next node
        node.next = node.next.next;
    }
}
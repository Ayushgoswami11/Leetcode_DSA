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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = null;

        // Step 1: Move fast pointer k - 1 steps ahead
        for (int i = 0; i < k - 1; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        // 'fast' is now at the k-th node from the beginning
        first = fast;

        // Step 2: Advance both fast and slow until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 'slow' is now at the k-th node from the end
        ListNode second = slow;

        // Step 3: Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list (Tortoise and Hare)
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half starting from 'slow'
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // Step 3: Compare both halves
        ListNode p2 = secondHalf;
        boolean isPalin = true;

        while (p2 != null) {
            if (firstHalf.val != p2.val) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            p2 = p2.next;
        }

        // (Optional Best Practice) Restore the list back to its original shape
        reverseList(secondHalf);

        return isPalin;
    }

    // Classic 3-pointer iterative list reversal
    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
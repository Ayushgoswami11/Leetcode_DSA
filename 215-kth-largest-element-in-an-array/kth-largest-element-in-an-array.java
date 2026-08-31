
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.offer(num);

            // Maintain the heap size strictly <= k
            if (minHeap.size() > k) {
                minHeap.poll(); // Discard the smallest element
            }
        }

        // The root contains the kth largest element
        return minHeap.peek();
    }
}
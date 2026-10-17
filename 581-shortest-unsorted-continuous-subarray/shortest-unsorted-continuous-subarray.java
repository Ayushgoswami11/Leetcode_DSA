class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int left = -1, right = -1;
        int maxSoFar = nums[0];
        int minSoFar = nums[n - 1];

        // Pass 1: Find the right boundary
        for (int i = 0; i < n; i++) {
            if (nums[i] < maxSoFar) {
                right = i; // This element is out of order
            } else {
                maxSoFar = nums[i];
            }
        }

        // If no right boundary was set, the array is already sorted
        if (right == -1) return 0;

        // Pass 2: Find the left boundary
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > minSoFar) {
                left = i; // This element is out of order
            } else {
                minSoFar = nums[i];
            }
        }

        return right - left + 1;
    }
}
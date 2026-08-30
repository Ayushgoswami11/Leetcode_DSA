class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to keep binary search space minimal
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        int halfLen = (m + n + 1) / 2;

        while (low <= high) {
            int i = low + (high - low) / 2; // Cut in nums1
            int j = halfLen - i;            // Corresponding cut in nums2

            // Edge cases handled with +/- infinity
            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check if partition is valid
            if (left1 <= right2 && left2 <= right1) {
                // Odd total elements
                if ((m + n) % 2 != 0) {
                    return Math.max(left1, left2);
                }
                // Even total elements
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                // Too far right in nums1 -> move left
                high = i - 1;
            } else {
                // Too far left in nums1 -> move right
                low = i + 1;
            }
        }

        return 0.0;
    }
}
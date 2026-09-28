class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int third = Integer.MIN_VALUE; // Candidate for nums[k]
        Deque<Integer> stack = new ArrayDeque<>(); // Candidates for nums[j]

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If we find nums[i] < nums[k], a valid 132 pattern exists
            if (nums[i] < third) {
                return true;
            }

            // Maintain monotonic stack: pop elements smaller than current nums[i]
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}
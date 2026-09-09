class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[102]; // handles values 0 to 100

        // Step 1: Count frequency of each number
        for (int num : nums) {
            count[num]++;
        }

        // Step 2: Convert to prefix sums
        // count[i] will store total numbers <= i
        for (int i = 1; i <= 101; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build result
        // Elements strictly smaller than x is count[x - 1]
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }

        return result;
    }
}
class Solution {
    public int[] countBits(int n) {
        // Output array of size n + 1
        int[] ans = new int[n + 1];
        
        // Base case: ans[0] is automatically initialized to 0
        
        // Bottom-up DP: Build the solution using previously computed states
        for (int i = 1; i <= n; i++) {
            // i >> 1 is equivalent to i / 2
            // i & 1 acts as a modulo check (returns 1 if odd, 0 if even)
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}
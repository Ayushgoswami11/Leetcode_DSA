class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        
        // Base case: top row has 1 path for every cell
        for (int c = 0; c < n; c++) {
            dp[c] = 1;
        }

        // Iterate through remaining rows
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                // new dp[c] = old dp[c] (from top) + dp[c-1] (from left)
                dp[c] += dp[c - 1];
            }
        }

        return dp[n - 1];
    }
}
import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Base Requirement: Everyone gets at least 1 candy initially
        Arrays.fill(candies, 1);
        
        // Pass 1: Left-to-Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Pass 2: Right-to-Left
        // Look at the right neighbor. If current rating is higher, ensure balance.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Take the max to avoid breaking the left-to-right constraint already set
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }
}

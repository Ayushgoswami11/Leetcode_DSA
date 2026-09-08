class Solution {
    public int numSub(String s) {
        long total = 0;
        long consecutiveOnes = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                consecutiveOnes++;
                total = (total + consecutiveOnes) % MOD;
            } else {
                consecutiveOnes = 0;
            }
        }

        return (int) total;
    }
}
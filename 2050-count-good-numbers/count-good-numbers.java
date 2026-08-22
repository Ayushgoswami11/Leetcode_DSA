class Solution {
    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; // Ceil(n / 2)
        long oddPositions = n / 2;         // Floor(n / 2)

        long power5 = modPow(5, evenPositions);
        long power4 = modPow(4, oddPositions);

        return (int) ((power5 * power4) % MOD);
    }

    // Recursive fast modular exponentiation: (base^exp) % MOD
    private long modPow(long base, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = modPow(base, exp / 2);
        long halfSquared = (half * half) % MOD;

        if (exp % 2 == 0) {
            return halfSquared;
        } else {
            return (halfSquared * (base % MOD)) % MOD;
        }
    }
}
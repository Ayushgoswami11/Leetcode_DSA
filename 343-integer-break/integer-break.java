class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int product = 1;

        // Greedily take factors of 3 until remaining n is <= 4
        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        // Multiply remaining 2, 3, or 4
        product *= n;

        return product;
    }
}
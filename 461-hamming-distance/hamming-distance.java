class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;

        while (xor != 0) {
            xor = xor & (xor - 1); // Clears the lowest set bit
            distance++;
        }

        return distance;
    }
}
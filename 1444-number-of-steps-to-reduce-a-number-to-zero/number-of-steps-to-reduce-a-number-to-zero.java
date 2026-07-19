class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;     // Even rule
            } else {
                num -= 1;     // Odd rule
            }
            steps++;
        }
        
        return steps;
    }
}
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 represents '+', -1 represents '-'

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;

                // Multiply with sign before '('
                result *= stack.pop();

                // Add the result computed before '('
                result += stack.pop();
            }
        }

        // Add any remaining trailing number
        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}
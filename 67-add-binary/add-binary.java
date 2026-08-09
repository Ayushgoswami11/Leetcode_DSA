class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop as long as there are digits to process or a leftover carry
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Append binary digit (0 or 1)
            result.append(sum % 2);

            // Update carry (1 if sum >= 2, else 0)
            carry = sum / 2;
        }

        // Reverse to get digits in correct left-to-right order
        return result.reverse().toString();
    }
}
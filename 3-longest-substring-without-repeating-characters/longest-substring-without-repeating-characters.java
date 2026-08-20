import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If the character was seen inside the current window, shift left
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }

            // Update the last seen position of the current character
            lastIndex[ch] = right;

            // Calculate current window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
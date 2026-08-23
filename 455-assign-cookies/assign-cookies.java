import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childPtr = 0;
        int cookiePtr = 0;

        while (childPtr < g.length && cookiePtr < s.length) {
            if (s[cookiePtr] >= g[childPtr]) {
                childPtr++; // Child is happy, move to next child
            }
            cookiePtr++; // Move to next cookie regardless
        }

        // childPtr represents total number of content children
        return childPtr;
    }
}
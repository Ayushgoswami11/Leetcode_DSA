
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        int n = s.length();
        // A 10-letter sequence requires at least 10 characters
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            
            // If already present in seen, add to repeated set
            if (!seen.add(sub)) {
                repeated.add(sub);
            }
        }

        return new ArrayList<>(repeated);
    }
}
class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            int len = word.length();
            int index = word.charAt(len - 1) - '1'; // Converts '1'-'9' to 0-8
            
            String actualWord = word.substring(0, len - 1);
            
            result[index] = actualWord;
        }

        return String.join(" ", result);
    }
}
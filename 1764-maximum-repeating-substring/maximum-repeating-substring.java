class Solution {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        StringBuilder repeatedWord = new StringBuilder(word);
        
        while (sequence.contains(repeatedWord)) {
            k++;
            repeatedWord.append(word); 
        }
        
        return k;
    }
}
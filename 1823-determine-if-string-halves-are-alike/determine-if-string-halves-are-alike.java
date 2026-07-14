class Solution {


    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int mid=n/2;
        s=s.toLowerCase();
        int vowelCount=0;
        

        for(int i=0;i<mid;i++){
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
            if (isVowel(s.charAt(i + mid))) {
                vowelCount--;
            }
        }
        return vowelCount==0;
            
    }
    private boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u';
    }
}
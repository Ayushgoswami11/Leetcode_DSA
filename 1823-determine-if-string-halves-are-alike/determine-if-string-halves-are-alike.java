class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int mid=n/2;
        String s1=s.toLowerCase();
        int c1=0;
        int c2=0;

        for(int i=0;i<mid;i++){
            if(s1.charAt(i)=='a'||s1.charAt(i)=='e'||s1.charAt(i)=='i'||s1.charAt(i)=='o'||s1.charAt(i)=='u'){
                c1++;
            }
        }
        for(int i=mid;i<n;i++){
            if(s1.charAt(i)=='a'||s1.charAt(i)=='e'||s1.charAt(i)=='i'||s1.charAt(i)=='o'||s1.charAt(i)=='u'){
                c2++;
            }
        }
        return c1==c2;

    }
}
class Solution {
    public void reverseString(char[] s) {
        //helper(s,0,s.length-1);
        int high=s.length-1;
        int low=0;
        while(low<=high){
            char temp=s[low];
            s[low]=s[high];
            s[high]=temp;

            low++;
            high--;
        }
        
    }
    // private void helper(char[] s,int low,int high){
    //     if(low>=high){
    //         return; 
    //     }
    //     char temp=s[low];
    //     s[low]=s[high];
    //     s[high]=temp;

    //     helper(s,low+1,high-1);
    // }
}
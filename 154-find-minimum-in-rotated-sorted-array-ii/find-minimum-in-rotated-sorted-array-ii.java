class Solution {
    public int findMin(int[] nums) {
        int minval=Integer.MAX_VALUE;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            minval=Math.min(minval,nums[low]);
            low++;
        }
        return minval;
    }
}
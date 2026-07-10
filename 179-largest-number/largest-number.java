class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }
        // for(int i=0;i<strs.length;i++){
        //     for(int j=i+1;j<strs.length;j++){
        //         String a=strs[i]+strs[j];
        //         String b=strs[j]+strs[i];

        //         if(b.compareTo(a)>0){
        //             String temp=strs[i];
        //             strs[i]=strs[j];
        //             strs[j]=temp;
        //         }
        //     }
        // }
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        if(strs[0].equals("0")){
            return "0";
        }


        StringBuilder sb= new StringBuilder();
        for(String str:strs){
            sb.append(str);
        }
        return sb.toString();
        
        
    }
}
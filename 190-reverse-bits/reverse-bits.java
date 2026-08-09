class Solution {
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<32;i++){
            result<<=1;//creating space for the incoming bits

            result|=(n&1);// AND is used to fetch the LSB from the number
                         // OR is used to append the newly fetched lsb to the result 
            n>>=1;


        }
        return result;
        
    }
}
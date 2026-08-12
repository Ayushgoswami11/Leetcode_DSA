class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int totalElements = 1 << n; // 2^n elements
        
        for (int i = 0; i < totalElements; i++) {
            // Formula to convert binary integer i to Gray code
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}
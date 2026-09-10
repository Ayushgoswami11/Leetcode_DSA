class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        // Step 1: Count occurrences of each number in arr1
        for (int num : arr1) {
            count[num]++;
        }

        int[] result = new int[arr1.length];
        int index = 0;

        // Step 2: Place elements according to the relative order in arr2
        for (int num : arr2) {
            while (count[num] > 0) {
                result[index++] = num;
                count[num]--;
            }
        }

        // Step 3: Place remaining elements in ascending order
        for (int i = 0; i <= 1000; i++) {
            while (count[i] > 0) {
                result[index++] = i;
                count[i]--;
            }
        }

        return result;
    }
}
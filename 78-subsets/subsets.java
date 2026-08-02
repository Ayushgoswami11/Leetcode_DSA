import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking recursion with an empty tracking list at index 0
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, int start) {
        // Every state reached in the decision tree is a valid subset, so add a copy to results
        result.add(new ArrayList<>(currentList));

        for (int i = start; i < nums.length; i++) {
            // Take choice: Include nums[i] in the current subset context
            currentList.add(nums[i]);

            // Recurse: Move forward to process the next elements
            backtrack(result, currentList, nums, i + 1);

            // Backtrack: Remove nums[i] to explore alternative combination paths
            currentList.remove(currentList.size() - 1);
        }
    }
}
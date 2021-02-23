/**
 * Problem: Given an integer array with all positive numbers and no duplicates.
 *          Find the number of possible combinations that add up to a positive integer target.
 *          LeetCode: 377
 * Approach: Use Binary Search
 *
 * Time Complexity: O(logn)
 * Auxiliary Space: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2020-12-27
 */
public class CombinationSum4 {

    // Runtime: 1ms, Memory: 36.2MB
    public static int combinationSum4(int[] nums, final int Target) {
        if (nums == null || nums.length == 0)
            return 0;
        int dp[] = new int[Target + 1];
        dp[0] = 1;
        for (int target = 1; target <= Target; target++) {
            for (int j = 0; j < nums.length; j++) {
                if (target >= nums[j])
                    dp[target] += dp[target - nums[j]];
            }
        }
        return dp[Target];
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }

}

/*
Output:
——————————————————————
7

*/

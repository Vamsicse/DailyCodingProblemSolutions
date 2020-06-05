import java.util.Arrays;

/**
 * Problem: Find Longest Increasing Subsequence
 * Approach: Use DP
 *
 * Time Complexity:
 *         O(n^2)   - DP
 *         O(nlogN) - DP with Binary Search
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class LongestIncSequence {

    public static void main(String[] args) {
        int[] arr1 = new int[]{10,9,2,5,3,7,101,18};
        int[] arr2 = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(lengthOfLISUsingDPBS(arr1));
        System.out.println(lengthOfLISUsingDPBS(arr2));
    }

    // Time Complexity: O(n^2)
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = (maxval> dp[j])?maxval:dp[j];
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    // Time Complexity: O(nlogn)
    public static int lengthOfLISUsingDPBS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1); // Get the current position of i in dp array and set it to positive
            }
            dp[i] = num;
            if (i == len) { // If current number is bigger increment len
                len++;
            }
        }
        return len;
    }

}


// https://leetcode.com/articles/longest-increasing-subsequence/


/*

Output:
---------------------------
4
6


*/

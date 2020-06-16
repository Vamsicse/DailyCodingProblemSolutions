/**
 * Problem: Divide array into 2 subsets such that diff between sum of subsets is minimum.
 * Approach: Use DP.
 *
 * Time Complexity: O(n*sum)
 * Space Complexity: O(n*sum)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class PartitionSubsetSumMinDiff {

    // Runtime: 17ms, Memory: 38.9MB
    public int canPartition(int[] nums) {
        int n = nums.length, j;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int total = prefixSum[n];
        boolean[] dp = new boolean[total/2 + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] |= dp[i - num];
            }
        }
        for (j = dp.length - 1; j >= 0; j--) {
            if (dp[j]) {
                break;
            }
        }
        return total-j*2;
    }

    public static void main(String[] args) {
        PartitionSubsetSumMinDiff obj = new PartitionSubsetSumMinDiff();
        int diff = obj.canPartition(new int[]{5, 10, 15, 20, 25});
        System.out.println("Minimum difference between subsets is: " + diff);
        diff = obj.canPartition(new int[]{1, 5, 11, 5});
        System.out.println("Minimum difference between subsets is: " + diff);
    }

}

/*
Output:
——————————————————— 
Minimum difference between subsets is: 5
Minimum difference between subsets is: 0

*/

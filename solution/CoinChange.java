import java.util.Arrays;

/**
 * Problem: We are given different coin denominations and a total amount of money amount.
 *          Compute the fewest number of coins that you need to make up that amount.
 *          If that money cannot be made up by any combination of coins, return -1.
 * Approach: Bottom Up Dynamic Programming.
 *           Before calculating F(i), we have to compute all minimum counts for amounts up to i.
 *
 * Time Complexity: O(amount*coins). On each step the algorithm finds next F(i) in n iterations, where 1<=i<=amount.
 *                  Hence, total iterations are amount*coins.
 * Space Complexity: O(amount). Memoization table.
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,5,10,25}, 16));
        System.out.println(coinChange(new int[]{1,5}, 16));
        System.out.println(coinChange(new int[]{2}, 3));
    }

    // Runtime: 11ms, Memory: 39.1 MB
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


/*
Output:
——————————————————————
3
4
-1

*/


// LeetCode: https://leetcode.com/problems/coin-change

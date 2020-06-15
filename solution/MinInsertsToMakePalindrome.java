/**
 * Problem: Minimum Insertion Steps to Make a String Palindrome
 * Approach: DP
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class MinInsertsToMakePalindrome {

    // Runtime: 42ms, Memory:52.5MB
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp=new int[n][n];
        for (int span = 2; span <= n; ++span) {
            for (int i = 0; i <= n - span; ++i) {
                int j = i + span - 1;
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        MinInsertsToMakePalindrome obj = new MinInsertsToMakePalindrome();
        System.out.println(obj.minInsertions("v"));
        System.out.println(obj.minInsertions("leetcode"));
    }

}


/*
Output:
——————————————————— 

0
5

*/

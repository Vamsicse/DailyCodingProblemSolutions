/**
 * Problem: LC:1035. A straight line connecting two numbers nums1[i] and nums2[j] such that nums1[i] == nums2[j]
 *          The line we draw does not intersect any other connecting (non-horizontal) line.
 *          Return the maximum number of connecting lines we can draw in this way.
 * Approach: This is similar to Longest Common Subsequence.
 *
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2020-12-27
 */
public class IntersectingLines {

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
        System.out.println(maxUncrossedLines(new int[]{}, new int[]{}));
    }

    // Runtime: 4ms, Memory: 38.6MB
    public static int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length, dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        return dp[m][n];
    }

}

/*
Output:
——————————————————————

2
3
2
0

*/


// https://leetcode.com/problems/uncrossed-lines
/**
 * Problem: LC:1035. A straight line connecting two numbers nums1[i] and nums2[j] such that nums1[i] == nums2[j]
 *          The line we draw does not intersect any other connecting (non-horizontal) line.
 *          Return the maximum number of connecting lines we can draw in this way.
 * Approach: This is similar to Longest Common Subsequence.
 *
 * Time Complexity: O(n*n)
 * Space Complexity: O(n)
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

    // Runtime: 3ms, Memory: 37.1MB
    public static int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m < n) return maxUncrossedLines(B, A);
        int dp[] = new int[n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0, prev = 0, cur; j < n; j++) {
                cur = dp[j+1];
                if (A[i] == B[j]) dp[j+1] = 1+prev;
                else dp[j+1] = Math.max(dp[j+1], dp[j]);
                prev = cur;
            }
        }
        return dp[n];
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
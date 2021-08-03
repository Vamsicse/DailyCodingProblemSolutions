import java.util.HashSet;

/**
 * Problem: Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2. LC: 581
 * Approach: DFS solution with memorization. This looks slow but is actually faster than BFS! Think about it carefully, in this
 *      particular problem, search always ends at the same depth. DFS with memorization
 *      searches about the same amount of paths with the same length as BFS, if it is doesn't
 *      terminate on the first path found. Without the queue operations, the overall cost
 *      is only smaller if we don't count call stack. The most significant runtime reducer is
 *      probably the early termination.
 * Recurrence Function:
 *     TC: 2^n
 *     boolean isInterleaved( char[] S1, char S2, char S3) {
 *     if ( not (len(S1) != 0 or len(S2) != 0 or len(S3) != 0) )
 *        return true
 *     if (len(S3) == 0)
 *        return false
 *     return ((S3[0]==S1[0]) and isInterleaved(S1+1,S2,S3+1)) or ((S3[0]==S2[0]) and isInterleaved(S1,S2+1,S3+1))
 *     }
 *
 * Time complexity : O(m*n)
 * Space complexity : DFS-O(m*n) or DP-O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class InterleaveString {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
        System.out.println(isInterleaveUsingDP("aabcc","dbbca","aadbbcbcac"));
        System.out.println(isInterleaveUsingDP("aabcc","dbbca","aadbbbaccc"));
        System.out.println(isInterleaveUsingDP("cat","dog","catdog"));
    }

    // Runtime: 1ms, Memory: 39MB
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        HashSet<Integer> cache = new HashSet<>();
        return isInterleaveString(s1, s2, s3, 0, 0, cache);
    }

    private static boolean isInterleaveString(String s1, String s2, String s3, int p1, int p2, HashSet<Integer> cache) {
        if (p1 + p2 == s3.length())
            return true;
        if (cache.contains(p1 * s3.length() + p2))
            return false;
        // no need to store actual result, if we found path, we have already terminated.
        cache.add(p1 * s3.length() + p2);
        boolean match1 = p1 < s1.length() && s3.charAt(p1 + p2) == s1.charAt(p1);
        boolean match2 = p2 < s2.length() && s3.charAt(p1 + p2) == s2.charAt(p2);
        if (match1 && match2)
            return isInterleaveString(s1, s2, s3, p1 + 1, p2, cache) || isInterleaveString(s1, s2, s3, p1, p2 + 1, cache);
        else if (match1)
            return isInterleaveString(s1, s2, s3, p1 + 1, p2, cache);
        else if (match2)
            return isInterleaveString(s1, s2, s3, p1, p2 + 1, cache);
        else
            return false;
    }

    // Runtime: 3ms, Memory: 37.1MB, TC: O(m*n), SC: O(n)
    // Approach: Store the results of the prefixes of the strings processed so far.
    public static boolean isInterleaveUsingDP(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i==0 && j==0) {
                    dp[j] = true;
                } else if (i==0) {
                    dp[j] = dp[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if (j==0) {
                    dp[j] = dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                } else {
                    dp[j] =  (dp[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[s2.length()];
    }
}

/*
Output:
——————————————————————
true
false

https://leetcode.com/problems/interleaving-string/discuss/31904/Summary-of-solutions-BFS-DFS-DP
*/
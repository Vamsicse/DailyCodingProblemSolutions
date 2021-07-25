import java.util.HashSet;

/**
 * Problem: Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2. LC: 581
 * Approach: DFS solution with memorization. This looks slow but is actually faster than BFS! Think about it carefully, in this
 *      particular problem, search always ends at the same depth. DFS with memorization
 *      searches about the same amount of paths with the same length as BFS, if it is doesn't
 *      terminate on the first path found. Without the queue operations, the overall cost
 *      is only smaller if we don't count call stack. The most significant runtime reducer is
 *      probably the early termination
 *
 * Time complexity : O(m+n)
 * Space complexity : O(m+n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class InterleaveString {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
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
}

/*
Output:
——————————————————————
true
false

 */
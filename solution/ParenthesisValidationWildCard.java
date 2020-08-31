/**
 * Problem: Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid.
 *          * can act as substitute for '(' or ')'
 * Approach:
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class ParenthesisValidationWildCard {

    public static void main(String[] args) {
        System.out.println(checkValidString("(()*)"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString(")*("));
    }

    // Runtime: 0ms, Memory: 37.2 MB
    public static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

}


/*
Output:
——————————————————————
true
true
false

*/

// LeetCode: https://leetcode.com/problems/valid-parenthesis-string

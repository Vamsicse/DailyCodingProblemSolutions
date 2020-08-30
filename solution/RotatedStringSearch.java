/**
 * Problem: Given 2 strings A, B. Find if A can be rotated to get B
 * Approach 1: Simple Check. [TC: O(n^2), SC: O(n)]
 * Approach 2: Use Z algorithm (Linear time pattern searching Algorithm)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class RotatedStringSearch {

    public static void main(String[] args) {
        String a = "abcde";
        String b = "cdeab";
        System.out.println(search(a,b));
    }

    // Runtime: 0ms, Memory: 37.5 MB, TC: O(n^2), SC: O(n)
    static boolean search(String A, String B){
        return A.length() == B.length() && (A+A).contains(B);
    }

}

// LeetCode: https://leetcode.com/problems/rotate-string

/*
Output:
——————————————————————
true

*/

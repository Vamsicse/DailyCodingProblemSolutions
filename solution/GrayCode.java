import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Find Gray Code Sequence.
 * Approach: we have n iterations and at each iteration "i" we run through our list (which is a gray code for "i-1")
 *           in reverse adding 1 to the front of bit-wise representation of a current number.
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class GrayCode {

    public static void main(String[] args) {
        System.out.println(grayCode(0));
        System.out.println(grayCode(2));
    }

    // Runtime: 0ms, Memory: 37.3 MB
    public static List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<>();
        // i-th code sequence of the gray-code
        for (int i = 0; i < 1 << n; i++) {.     // i < pow(2,n)
            code.add(i ^ (i >> 1));  // i ^ (i >> 1) gives binary number
        }
        return code;
    }

}

/*

LeetCode: https://leetcode.com/problems/gray-code

Output:
——————————————————————

[0]
[0, 1, 3, 2]

*/

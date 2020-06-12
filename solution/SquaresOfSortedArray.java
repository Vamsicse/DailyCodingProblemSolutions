import java.util.Arrays;

/**
 * Problem: Given sorted ARRAY in non-decreasing order, return array of squares of each number, also in sorted non-decreasing order.
 * Approach: 2 Pointer Approach. Keep checking from both ends.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] arr = {-9, -2, 0, 2, 3};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    // Runtime: 1ms, Memory: 41.4MB
    public static int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        for (int i = A.length - 1, l = 0, r = A.length - 1; i >= 0; i--) {
            ans[i] = (A[l] * A[l]) <= (A[r] * A[r]) ? (A[r] * A[r--]) : (A[l] * A[l++]);
        }
        return ans;
    }

}

/*
Output:
—————————————————————— 

[0, 4, 4, 9, 81]


*/

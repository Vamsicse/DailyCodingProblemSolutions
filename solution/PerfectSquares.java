/**
 * Problem: Given an integer n, return the least number of perfect square numbers that sum to n.
 *  A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Approach: Use Lagrange's 4 square theorem :https://www.geeksforgeeks.org/lagranges-four-square-theorem/
 *   Bachet's conjecture, states that every natural number can be represented as the sum of four integer squares.
 *
 * Time Complexity: O(sqrt(n))
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println("Perfect Squares for 12: " + numSquares(12));
        System.out.println("Perfect Squares for 13: " + numSquares(13));
        System.out.println("Perfect Squares for 27: " + numSquares(27));
    }

    private static boolean validSquare(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }

    // Runtime: 1ms, Memory: 38MB
    public static int numSquares(int n) {
        if (n < 4)
            return n;
        if (validSquare(n))
            return 1;
        while ((n & 3) == 0)
            n >>= 2;
        if ((n & 7) == 7)
            return 4;
        int x = (int) Math.sqrt(n);
        for (int i = 1; i <= x; i++) {
            if (validSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }
}

/*
Output:
——————————————————————

Perfect Squares for 12: 3
Perfect Squares for 13: 2
Perfect Squares for 27: 3

*/
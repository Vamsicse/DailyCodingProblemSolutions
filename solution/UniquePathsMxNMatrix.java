/**
 * Problem: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *  The robot can only move either down or right at any point in time.
 *  The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *  How many possible unique paths are there?
 *  Approach: Keep on multiplying from m+1 to m+n & divide the result with counter.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class UniquePathsMxNMatrix {

    public static void main(String[] args) {
        System.out.println("2*2: " + uniquePaths(2,2));
        System.out.println("3*2: " + uniquePaths(3,2));
        System.out.println("3*3: " + uniquePaths(3,3));
        System.out.println("3*7: " + uniquePaths(3,7));
        System.out.println("5*5: " + uniquePaths(5,5));
    }

    private static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){ // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
        return (int)res;
    }

}

/*
Output:
——————————————————————

2*2: 2
3*2: 3
3*3: 6
3*7: 28
5*5: 70

*/


// LeetCode 62: https://leetcode.com/problems/unique-paths/

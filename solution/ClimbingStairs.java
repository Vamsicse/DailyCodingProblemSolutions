import java.util.Arrays;

/**
 * Problem: You are climbing a stair case. It takes n steps to reach to the top.
 *          Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Approach: Use Fibonacci Number/Fibonacci formula/Recursion
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairsUsingFibonacciNumber(4));
        System.out.println(obj.climbStairsUsingFibonacciFormula(4));

        System.out.println(obj.climbStairs(5,  1,3,5) ); // Use only steps 1,3,5
    }

    // Runtime: 0ms, Memory: 36.1MB, Time Complexity: O(n), Space Complexity: O(1)
    public int climbStairsUsingFibonacciNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Runtime: 0ms, Memory: 36.1MB, Time Complexity: O(logN), Space Complexity: O(1)
    public int climbStairsUsingFibonacciFormula(int n) {
        double sqrt5=Math.sqrt(5);
        double fib = Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fib/sqrt5);
    }

    public int climbStairs(int n, int... steps) {
        Arrays.sort(steps);
        return _countUniqueWays(n, 0, 0, new int[]{1,2});
    }

    private int _countUniqueWays(int n, int cur, int res, int... steps) {
        if (cur == n) {
            res++;
        }
        if (cur < n) {
            for (int i = 0; i < steps.length; i++)
                res = _countUniqueWays(n, cur + steps[i], res, steps);
        }
        return res;
    }

}

// https://leetcode.com/problems/climbing-stairs/solution/


/*
Output:
——————————————————————

5
5
8


*/

/**
 * Problem: Find Nth Fibonacci number.
 * Approach: Using the golden ratio, a.k.a Binet's formula: phi = pow[{(1+sqrt(5))/2},N]/sqrt(5)
 *
 * Time Complexity: O(1) for Binet's approach, O(n) for Iterative approach
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib1(8));
        System.out.println(fib2(8));
    }

    // Runtime: 0ms, Memory: 36.3 MB
    public static int fib1(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
    }

    // Runtime: 0ms, Memory: 36.3 MB
    public static int fib2(int N) {
        if (N < 2) {
            return N;
        }
        if (N == 2) {
            return 1;
        }
        int current = 0;
        int a = 1, b = 1;
        for (int i = 3; i <= N; i++) {
            current = a + b;
            a = b;
            b = current;
        }
        return current;
    }

}


/*
Output:
——————————————————————
21
21

*/

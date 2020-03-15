/**
 * Problem: Divide integers without using divide operator
 * Approach: Subtract divisor from dividend repeatedly and track the count
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2017-12-27
 */
public class DivideIntegers {

    // Function to divide a by b and return floor value it
    static int divide(int dividend, int divisor) {
        // Calculate sign of divisor i.e, sign will be negative only if either one of them is negative otherwise it will be positive
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        dividend = Math.abs(dividend); // Update both divisor and dividend positive
        divisor = Math.abs(divisor);
        int quotient = 0;  // Initialize the quotient
        while (dividend >= divisor) {
            dividend -= divisor;
            ++quotient;
        }
        return sign * quotient;
    }

    public static void main (String[] args) {
        int a = 10;  int b = 3;
        System.out.println(divide(a, b));

        a = 43;       b = -8;
        System.out.println(divide(a, b));
    }

}


/*
Output:
—————————————————————— 

3
-5


*/

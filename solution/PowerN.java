/**
 * Problem: Compute x^y
 * Approach: Calculate power(x, y/2) once and store it
 *
 * Time Complexity: O(log n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class PowerN {

    // Runtime: 0ms, Memory: 36.5MB
    static float power(float x, int y) {
        float temp;
        if(y == 0) {
            return 1;
        }
        temp = power(x, y/2);
        if (y%2 == 0) { // Even Power
            return temp * temp;
        }
        else {   // Odd Power
            if(y > 0)
                return temp * temp * x;
            else
                return (temp * temp) / x;
        }
    }

    public static void main(String[] args) {
        float x = 15;
        int y = 3;
        System.out.printf("%f", power(x, y));
    }

}


/*
Output:
—————————————————————— 

3375.000000


*/



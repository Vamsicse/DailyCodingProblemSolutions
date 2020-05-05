/**
 * Problem: Find the total number of set bits in all integers between 1 and N.
 * Approach: Use bitwise operators for efficiency.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class CountingBits {

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }

    // Runtime: 1ms, Memory: 43.4MB
    public static int countBits(int num) {
        int sum=0;
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) {
            f[i] = f[i >> 1] + (i & 1);
            sum += f[i];
        }
        return sum;
    }

}


/*
Output:
—————————————————————— 

7



*/

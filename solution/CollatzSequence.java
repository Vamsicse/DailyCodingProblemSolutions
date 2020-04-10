import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Find the number which gives longest Collatz sequence.
 * Approach: Use Recursion and Memoization to eliminate redundant calculations.
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class CollatzSequence {

    private static Map<Integer, Integer> collatzMap = new HashMap<>();

    public static void main (String[] args) {
        int chainSize, max = 0, result = 0;
        for (int i = 2; i < 100000; i++) {
            chainSize = collatz(i);
            if (chainSize > max) {
                max = chainSize;
                result = i;
            }
            collatzMap.put(i,chainSize);
        }
        System.out.printf("Number=%d, ChainSize=%d", result, max);
    }

    private static int collatz(int n) {
        int result = 1;
        if(collatzMap.containsKey(n)) {
            return collatzMap.get(n);
        }
        else {
            if(n==1) {
                result = 1;
            }
            else if(n%2==0) {
                result += collatz(n/2);
            }
            else {
                result += collatz(3 * n + 1);
            }
            collatzMap.put(n, result);
            return result;
        }
    }

}



/*
Output:
—————————————————————— 

Number=77031, ChainSize=351


*/


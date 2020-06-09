/**
 * Problem: Returns next higher number with same number of set bits as x.
 * Approach: Use bit wise operators for faster calculation.
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class NextIntegerWithSameTotalBits {

    public static void main(String[] args) {
        System.out.println(findNextNumberWithSameTotalSetBits(5));
        System.out.println(findNextNumWithSameTotalSetBits(5));
        System.out.println(findNextNumberWithSameTotalSetBits(7));
        System.out.println(findNextNumWithSameTotalSetBits(7));
        System.out.println(findNextNumberWithSameTotalSetBits(11));
        System.out.println(findNextNumWithSameTotalSetBits(11));
    }

    // Approach 1
    static int findNextNumberWithSameTotalSetBits(int num) {
        int rightOne, nextHigherOneBit, rightOnesPattern, next = 0;
        if(num > 0) {
            // right most set bit
            rightOne = num & -num;

            // reset the pattern and set next higher bit left part of x will be here
            nextHigherOneBit = num + rightOne;

            // nextHigherOneBit is now part [D] of the above explanation. isolate the pattern
            rightOnesPattern = num ^ nextHigherOneBit;

            // right adjust pattern
            rightOnesPattern = (rightOnesPattern)/rightOne;

            // correction factor
            rightOnesPattern >>= 2;

            // rightOnesPattern is now part [A] of the above explanation. integrate new pattern (Add [D] and [A])
            next = nextHigherOneBit | rightOnesPattern;
        }
        return next;
    }

    // Approach 2
    static int findNextNumWithSameTotalSetBits(int num) {
        int setBits = countSetBitsInNumber(num);
        while (countSetBitsInNumber(++num) != setBits) { }
        return num;
    }

    // Utility method for Approach 2
    static int countSetBitsInNumber(int num) {
        int count=0;
        while (num!=0) {
            num = num & (num-1);   // Shift given integer by 1 & increment count if last bit is 1.
            count++;
        }
        return count;
    }

}




/*
Output:
——————————————————————

6
6
11
11
13
13


*/

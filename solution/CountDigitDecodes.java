/**
 * Problem: Count Possible Decodes of a given Digit Sequence
 * Approach: Use Dynamic Programming.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 * @implNote Compare with Fibonacci Series using DP
 */
public class CountDigitDecodes {

    public static void main(String[] args) {
        String str = "111";
        System.out.println("# of possible combinations for " + str + " is: " + countDecodes(str));

        str = "121";
        System.out.println("# of possible combinations for " + str + " is: " + countDecodes(str));

        str = "1234";
        System.out.println("# of possible combinations for " + str + " is: " + countDecodes(str));
    }

    private static int countDecodes(String s) {
        char digits[] = s.toCharArray();
        int n = s.length();
        int count[] = new int[n + 1];
        count[0] = 1;   count[1] = 1;
        if(digits[0]=='0')   //for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++) {
            count[i] = 0;
            // If the last digit is not 0, then last digit must add to the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];
            // If second last digit is smaller than 2 and last digit is smaller than 7, then last two digits form a valid character
            if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

}



/*
Output:
———————————————————————————————————————————

# of possible combinations for 111 is: 3
# of possible combinations for 121 is: 3
# of possible combinations for 1234 is: 3

*/


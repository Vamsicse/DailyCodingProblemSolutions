/**
 * Problem: Count Possible Decodes of a given Digit Sequence
 * Approach: Use Dynamic Programming.
 *    Condition to check last digit can be included or not
 *       if (digit[i-1] is not '0')
 *            count[i] += count[i-1]
 *    Condition to check the last two digits contribution
 *       if (digit[i-2] is 1 or (digit[i-2] is 2 and digit[i-1] is less than 7))
 *            count[i] += count[i-2]
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 *
 * Compare with 'Fibonacci Series using DP'
 */
public class CountDigitDecodes {

    public static void main(String[] args) {
        String str = "111";
        System.out.println("# of possible combinations for " + str + " is: " + numDecodings(str));

        str = "121";
        System.out.println("# of possible combinations for " + str + " is: " + numDecodings(str));

        str = "1234";
        System.out.println("# of possible combinations for " + str + " is: " + numDecodings(str));
    }

    // Runtime: 0ms, Memory: 37.2MB, SC: O(1)
    private static int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int r1 = 1, r2 = 1; // r2: decode ways of s[i-2] , r1: decode ways of s[i-1]
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') // 0 voids ways of the last because zero cannot be used separately
                r1 = 0;
            // possible two-digit letter, so new r1 is sum of both while new r2 is the old r1
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) < '7') {
                r1 = r2 + r1;
                r2 = r1 - r2;
            }

            // one-digit letter, no new way added
            else {
                r2 = r1;
            }
        }
        return r1;
    }

    // Runtime: 1ms, Memory: 39.4MB, SC: O(n)
    private static int countDecodes(String s) {
        char digits[] = s.toCharArray();
        int n = s.length();
        int count[] = new int[n + 1];
        count[0] = count[1] = 1;
        if(digits[0]=='0') {   //for base condition "01123" should return 0
            return 0;
        }
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

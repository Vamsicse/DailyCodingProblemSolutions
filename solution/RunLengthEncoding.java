/**
 * Problem: Run Length Encoding
 * Approach: Use a counter to track occurrences
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class RunLengthEncoding {

    public static void printEncoding(String str)
    {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 &&
                    str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            System.out.print(str.charAt(i));
            System.out.print(count);
        }
    }

    public static void main(String[] args)
    {
        String str = "wwwwaaadexxxxxxywww";
        System.out.print("Run Length Encoding for " + str  + " is: ");
        printEncoding(str);
        str = "AAAABBBCCDAA";
        System.out.print("\nRun Length Encoding for " + str  + " is: ");
        printEncoding(str);
    }
}


/*
Output:
—————————————————————— 

Run Length Encoding for wwwwaaadexxxxxxywww is: w4a3d1e1x6y1w3
Run Length Encoding for AAAABBBCCDAA is: A4B3C2D1A2


*/

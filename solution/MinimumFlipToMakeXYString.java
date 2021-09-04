/**
 * Problem: Given two strings s and p, return an array of all the start indices of p's anagrams in s. Answer can be in any order.
 * Approach: First, we make a pass over our input to determine the number of y's to the left of each element.
 *      We then make a second pass to find the number of x's to the right of each element.
 *      For any solution, there must be some element in our string for which everything to its left gets set to x, and everything to its right gets set to y.
 *      As a result, we can simply find the pairwise sum of these lists, and use the element which requires the smallest total number of flips.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class MinimumFlipToMakeXYString {

    public static void main(String[] args) {
        System.out.println(minFlips("yyx"));
        System.out.println(minFlips("xyxxxyxyyy"));
        System.out.println(minFlips("xyxxxyxyyx"));
        System.out.println(minFlips("xyxxxyxyyxxx"));
        System.out.println(minFlips("yyxxx"));
    }

    public static int minFlips(String s) {
        int n = s.length();
        int[] leftY = new int[n], rightX = new int[n];
        leftY[0] = 0;
        rightX[n - 1] = 0;

        for(int i = 1; i < n; i++) {
            leftY[i] = leftY[i - 1] + (s.charAt(i - 1) == 'y' ? 1 : 0);
        }
        for(int i = n - 2; i >= 0; i--) {
            rightX[i] = rightX[i + 1] + (s.charAt(i + 1) == 'x' ? 1 : 0);
        }
        int flips = n;
        for(int i = 0; i < n; i++) {
            flips = Math.min(flips, leftY[i] + rightX[i]);
        }
        return flips;
    }

}

/*
Output:
—————————
1
2
3
4
2

*/

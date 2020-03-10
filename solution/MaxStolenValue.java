/**
 * Problem: Find maximum possible stolen value from non-adjacent houses
 * Approach: Use Dynamic Programming
 * dp[i] = max (arr[i] + dp[i-2], dp[i-1])
 *
 * arr[i] + dp[i-2] is the case when thief decided to rob house i.
 * In that situation maximum value will be the current value of house + maximum value stolen till last
 * robbery at house not adjacent to house i which will be house i-2.
 *
 * dp[i-1] is the case when thief decided not to rob house i. So he will check adjacent house for maximum value stolen till now.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class MaxStolenValue {

    static int maxLoot(int arr[])
    {
        int n = arr.length;
        if (n == 0)
            return 0;
        int a = arr[0];
        if (n == 1)
            return a;
        int b = Math.max(arr[0], arr[1]);
        if (n == 2)
            return b;
        int c = 0;     // contains maximum stolen value at the end
        for (int i=2; i<n; i++)  {
            c = Math.max(arr[i]+a, b);
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("Max Loot for {6, 7, 1, 3, 8, 2, 4} is: " + maxLoot(new int[]{6, 7, 1, 3, 8, 2, 4}));
        System.out.println("Max Loot for {5, 3, 4, 11, 2} is: " + maxLoot(new int[]{5, 3, 4, 11, 2}));
    }

}





/*
Output:
-------------------------------------

Max Loot for {6, 7, 1, 3, 8, 2, 4} is: 19

Max Loot for {5, 3, 4, 11, 2} is: 16


*/

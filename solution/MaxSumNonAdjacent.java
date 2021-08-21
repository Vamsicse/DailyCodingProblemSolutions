/**
 * Problem: Find Maximum sum such that no two elements are adjacent.
 *          Also referred as Max Loot problem. Find maximum possible loot from non-adjacent houses.
 * Approach: Use DP.
 * Recurrence Function: f(arr,i) = max( arr[i]+f(arr,i-2), f(arr,i-1) ) 
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class MaxSumNonAdjacent {

    public static void main(String[] args) {
        int arr1[] = new int[]{5, 5, 10, 100, 10, 5};   // 110
        System.out.println("Max Sum of Non Adjacent elements is: " + maxLootNonAdjacent(arr1));
        int arr2[] = new int[]{2, 4, 6, 8};             // 12
        System.out.println("Max Sum of Non Adjacent elements is: " + maxLootNonAdjacent(arr2));
        int arr3[] = new int[]{5, 1, 1, 5};             // 10
        System.out.println("Max Sum of Non Adjacent elements is: " + maxLootNonAdjacent(arr3));
    }

    static int maxLootNonAdjacent(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int a = arr[0];
        if (n == 1) {
            return a;
        }
        int b = (arr[0]>arr[1]) ? arr[0] : arr[1] ;
        if (n == 2) {
            return b;
        }
        int c = 0;  // 'c' contains maximum stolen value at the end
        for (int i=2; i<n; i++) {
            c = Math.max(arr[i]+a, b);
            a = b;
            b = c;
        }
        return c;
    }

}



/*
Output:
—————————————————————— 

Max Sum of Non Adjacent elements is: 110
Max Sum of Non Adjacent elements is: 12
Max Sum of Non Adjacent elements is: 10


*/

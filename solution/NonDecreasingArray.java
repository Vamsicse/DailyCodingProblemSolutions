import java.util.Arrays;

/**
 * Problem: Given an array, find if it could become non-decreasing by modifying at most 1 element.
 * Approach: The strategy is to lower a[i-1] to match a[i] if possible - (a[i-2] not exist or no smaller than a[i]);
 *           otherwise rise a[i] to match a[i-1].
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] arr1 = {10, 5, 7};
        int[] arr2 = {10, 5, 1};
        int[] arr3 = {4, 2, 3};
        int[] arr4 = {4, 2, 1};
        System.out.println("Possibility for " + Arrays.toString(arr1) + " is: " + checkPossibility(arr1));
        System.out.println("Possibility for " + Arrays.toString(arr2) + " is: " + checkPossibility(arr2));
        System.out.println("Possibility for " + Arrays.toString(arr3) + " is: " + checkPossibility(arr3));
        System.out.println("Possibility for " + Arrays.toString(arr4) + " is: " + checkPossibility(arr4));
    }

    public static boolean checkPossibility(int[] a) {
        int modified = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                if (modified++ > 0) return false;
                if (i - 2 < 0 || a[i - 2] <= a[i]) a[i - 1] = a[i]; // lower a[i - 1]
                else a[i] = a[i - 1]; // rise a[i]
            }
        }
        return true;
    }

}



/*
Output:
——————————————————————

Possibility for [10, 5, 7] is: true
Possibility for [10, 5, 1] is: false
Possibility for [4, 2, 3] is: true
Possibility for [4, 2, 1] is: false


*/

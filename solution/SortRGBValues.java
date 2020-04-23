import java.util.Arrays;

/**
 * Problem: Sort RGB Values in linear time.
 * Approach: Use an if case for each of R,G,B values and swap and adjust pointers.
 *
 * Time complexity : O(n)
 * Space complexity : In place sorting.
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2019-12-27
 */
public class SortRGBValues {

    public static void main(String... args) {
        char[] arr = { 'G', 'B', 'R', 'R', 'B', 'R', 'G' };
        System.out.println("Before: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }

    public static void sort(char[] arr) {
        int b = arr.length - 1;
        for (int r=0, g=0; g <= b ; ) {
            if (arr[g] == 'R') {
                swap(arr, r, g);
                r++;
                g++;
            }
            else if (arr[g] == 'G') {
                g++;
            }
            else {
                swap(arr, g, b);
                b--;
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }

}



/*
Output:
—————————————————————— 

Before: [G, B, R, R, B, R, G]
After:  [R, R, R, G, G, B, B]


*/


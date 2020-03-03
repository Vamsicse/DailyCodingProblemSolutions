import java.util.Arrays;

/**
 * Problem: Find Smallest Positive number
 * Approach: Segregate positive numbers and find smallest postive number
 *
 * Time Complexity: ~ O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class SmallestPositiveNumber {

    static int segregate(int arr[], int size)
    {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive integers
                j++;
            }
        }
        System.out.println("After Segregation: " + Arrays.toString(arr));
        return j;  // return count of non-positive integers
    }

    /* Find smallest positive missing number that contains all positive integers */
    static int findMissingPositive(int arr[], int size)
    {
        int i;
        // Mark arr[i] as visited by making arr[arr[i] - 1] negative.
        // Note that 1 is subtracted because index start from 0 and positive numbers start from 1
        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0) {
                arr[x - 1] = -arr[x - 1];
            }
        }
        // Return the first index value at which is positive
        for (i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1; // 1 is added because indexes start from 0
            }
        }
        return size + 1;
    }

    /* Find smallest positive missing number that contains both positive and negative integers */
    static int findMissing(int arr[], int size)
    {
        // First separate positive and negative numbers
        int shift = segregate(arr, size);
        int arr2[] = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call findMissingPositive for positive part
        return findMissingPositive(arr2, j);
    }

    public static void main(String[] args) {
        int arr1[] = {0, 10, 2, -10, -20};
        System.out.println("Missing smallest positive number among " + Arrays.toString(arr1) + " is: " + findMissing(arr1, arr1.length));
        int arr2[] = {3, 4, -1, 1};
        System.out.println("Missing smallest positive number among " + Arrays.toString(arr2) + " is: " + findMissing(arr2, arr2.length));
        int arr3[] = {1, 2, 0};
        System.out.println("Missing smallest positive number among " + Arrays.toString(arr3) + " is: " + findMissing(arr3, arr3.length));
    }

}

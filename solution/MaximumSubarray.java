/**
 * Problem: Find the maximum sum of any contiguous subarray of the array.
 * Approach: Use Sliding window approach.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class MaximumSubarray {

    static int maxSubArraySum(int a[], int size) {
        int max_so_far = a[0], curr_max = a[0];
        for (int i = 1; i < size; i++) {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int a1[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is: " + maxSubArraySum(a1, a1.length));

        int a2[] = {34, -50, 42, 14, -5, 86};
        System.out.println("Maximum contiguous sum is: " + maxSubArraySum(a2, a2.length));
    }

}


/*
Output:
——————————————————————

Maximum contiguous sum is: 7
Maximum contiguous sum is: 137


*/

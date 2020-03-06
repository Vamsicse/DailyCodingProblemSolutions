/**
 * Problem: Find Subarray with given sum
 * Approach: Use sliding window protocol
 *
 * Time Complexity: O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
class SubArraySum
{
    /* Returns true if the there is a subarray of arr[] with sum equal to 'sum' otherwise returns false */
    static int subArraySum(int arr[], int n, int sum)
    {
        int curr_sum = arr[0], start = 0, i;
        for (i = 1; i <= n; i++) {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i-1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }
            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) {
                int p = i-1;
                System.out.println("Sum found between indexes " + start + " and " + p);
                return 1;
            }
            // Add this element to curr_sum
            if (i < n) {
                curr_sum = curr_sum + arr[i];
            }
        }
        System.out.println("No subarray found");
        return 0;
    }

    public static void main(String[] args) {
        int arr1[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n1 = arr1.length;
        int sum1 = 23;
        subArraySum(arr1, n1, sum1);

        int arr2[] = {1, 2, 3, 4, 5};
        int n2 = arr2.length;
        int sum2 = 9;
        subArraySum(arr2, n2, sum2);
    }
}



/*
Output:
----------

Sum found between indexes 1 and 4
Sum found between indexes 1 and 3


*/

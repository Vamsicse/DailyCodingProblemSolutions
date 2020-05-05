/**
 * TrappingRainWater Problem
 * Approach: One-pass
 * We will maintain two variables to store the maximum till that point
 *
 * Time complexity: O(n)
 * Space complexity: O(1) extra space. Only constant space required for left, right, left_max and right_max.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class TrappingRainWater {

    // Runtime: 1ms, Memory: 39.4MB [2 Pointer Approach]
    static int findWater(int arr[]) {
        int water = 0;
        int low = 0, high = arr.length - 1;
        int left_max = 0, right_max = 0;
        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (arr[low] > left_max)
                    left_max = arr[low];
                else
                    water += left_max - arr[low];
                low++;
            } else {
                if (arr[high] > right_max)
                    right_max = arr[high];
                else
                    water += right_max - arr[high];
                high--;
            }
        }
        return water;
    }

    // Runtime: 1ms, Memory: 39.2MB [DP Approach]
    public static int store(int[] arr) {
        int size = arr.length;
        if(size==0)
            return 0;
        int water = 0;
        int[][] dp = new int[2][size];
        dp[0][0] = arr[0];           // First element of array
        dp[1][size-1] = arr[size-1]; // Last element of array
        for(int i=1; i<size; i++) {  // Find biggest building from left
            dp[0][i] = Math.max(dp[0][i-1],arr[i]);
        }
        for(int i=size-2; i>=0; i--) {
            dp[1][i] = Math.max(dp[1][i+1],arr[i]); // Find biggest building from right
            water += Math.min(dp[0][i],dp[1][i]) - arr[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int arr[] = {4,0,2,1,3};// {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("[2 Pointer Approach]:  Maximum water that can be accumulated is " + findWater(arr));
        System.out.println("[Dynamic Programming]: Maximum water that can be accumulated is " + store(arr));
    }
}




/*
Output:
—————————
[2 Pointer Approach]:  Maximum water that can be accumulated is 6
[Dynamic Programming]: Maximum water that can be accumulated is 6

*/

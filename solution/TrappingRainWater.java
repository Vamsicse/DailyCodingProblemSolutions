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
        int result = 0;
        int left_max = 0, right_max = 0;
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)
                    left_max = arr[lo];
                else
                    result += left_max - arr[lo];
                lo++;
            } else {
                if (arr[hi] > right_max)
                    right_max = arr[hi];
                else
                    result += right_max - arr[hi];
                hi--;
            }
        }
        return result;
    }

    // Runtime: 1ms, Memory: 39.2MB [DP Approach]
    public int trap(int[] arr) {
        int size = arr.length;
        if(size==0)
            return 0;
        int[][] dp = new int[2][size];
        dp[0][0] = arr[0];
        dp[1][size-1] = arr[size-1];
        int res = 0;
        for(int i = 1;i<size;i++){
            dp[0][i] = Math.max(dp[0][i-1],arr[i]);
        }
        for(int i = size-2;i>=0;i--){
            dp[1][i] = Math.max(dp[1][i+1],arr[i]);
            res+=Math.min(dp[0][i],dp[1][i]) - arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Maximum water that can be accumulated is " + findWater(arr));
    }
}




/*
Output:
—————————
Maximum water that can be accumulated is 6

*/

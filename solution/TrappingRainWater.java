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


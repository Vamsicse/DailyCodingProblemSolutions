/**
 * Problem: LC918. Given a circular array of integers, find the maximum possible sum of a non-empty subarray.
 * Approach: There are 2 cases here.
 *      Case 1. The first is that the subarray take only a middle part, and we know how to find the max subarray sum.
 *      Case2. The second is that the subarray take a part of head array and a part of tail array.
 *      We can apply this case to the first one.
 *      The maximum result equals to the total sum minus the minimum subarray sum.
 *      So the max subarray circular sum equals to
 *      max(the max subarray sum, the total sum - the min subarray sum)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{8, -1, 3, 4}));
        System.out.println(maxSubarraySumCircular(new int[]{-4, 5, 1, 0}));
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    //Runtime: 4ms, Memory: 44.8MB
    public static int maxSubarraySumCircular(int[] arr) {
        int total = 0, maxSum = arr[0], curMax = 0, minSum = arr[0], curMin = 0;
        for (int a : arr) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

}

/*
Output:
——————————————————————

15
6
3
10
4
3
-1

*/


// https://leetcode.com/problems/maximum-sum-circular-subarray/
// https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass


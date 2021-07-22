/**
 * Problem: Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 *          Return the shortest such subarray and output its length. LC: 581
 * Approach: Find max and min values to find the range.
 *
 * Time complexity : O(n)
 * Space complexity : O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class ShortestUnsortedContinuousSubarray {

    // Runtime: 1ms, Memory: 40MB
    public static int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max)
                end = i;
            if (A[n-1-i] > min)
                beg = n-1-i;
        }
        return end - beg + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 7, 5, 6, 9};
        System.out.println(findUnsortedSubarray(arr1));
        int[] arr2 = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(arr2));
        int[] arr3 = {1,2,3,4};
        System.out.println(findUnsortedSubarray(arr3));
        int[] arr4 = {1};
        System.out.println(findUnsortedSubarray(arr4));
    }

}


/*
Output:
——————————————————————
3
5
0
0

 */
import java.util.Arrays;

/**
 * Problem: Find First and Last Position of Element in Sorted Array. LeetCode: #34
 * Approach: Use Binary Search
 *
 * Time Complexity: O(logn)
 * Auxiliary Space: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2020-12-27
 */
public class ElementFirstLastPositionSortedArray {

    // Returns leftmost/rightmost index at which 'target' should be inserted in sorted array `nums`
    // Runtime: 0ms, Memory: 44MB
    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] positions = new int[2];
        positions[0] = helper(nums, target, false);
        positions[1] = helper(nums, target, true);
        return positions;
    }

    private static int helper(int[] nums, int target, boolean equals) {
        int l = 0, r = nums.length - 1;
        int result = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                result = mid;
            if (nums[mid] < target || (nums[mid] == target && equals)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10},8)));
    }
}

/*
Output:
——————————————————————

[3, 4]


*/

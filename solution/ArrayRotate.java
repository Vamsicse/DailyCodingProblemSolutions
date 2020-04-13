import java.util.Arrays;

/**
 * Problem: Rotate Array
 * Approach: Reverse all elements of array.
 *  Then, reversing first k elements followed by reversing rest n-k elements gives result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class ArrayRotate {

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

}



/*
Output:
—————————————————————— 

[4, 5, 1, 2, 3]


*/

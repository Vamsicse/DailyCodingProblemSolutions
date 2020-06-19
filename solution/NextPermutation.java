import java.util.Arrays;

/**
 * Problem: Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * Approach: Find biggest element scanning from right to left, and swap it.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String... z){
        int[] arr1 = new int[]{1,2,3};
        nextPermutation(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{2,1,3};
        nextPermutation(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{3,2,1};
        nextPermutation(arr3);
        System.out.println(Arrays.toString(arr3));
    }

}

/*
Output:
———————————————————
[1, 3, 2]
[2, 3, 1]
[1, 2, 3]

*/

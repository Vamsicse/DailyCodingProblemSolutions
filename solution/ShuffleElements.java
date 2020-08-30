import java.util.Arrays;
import java.util.Random;

/**
 * Problem: Shuffle given elements.
 * Approach: For each iteration generate a random number less than size of array.
 *           Swap the current element with element present in random location generated.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class ShuffleElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        shuffleArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Runtime: 72ms, Memory: 47.9 MB
    public static int[] shuffleArray(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int newPos = new Random().nextInt(nums.length);

            int temp = nums[i];
            nums[i] = nums[newPos];
            nums[newPos] = temp;

            i++;
        }
        return nums;
    }

}


// LeetCode: https://leetcode.com/problems/shuffle-an-array

/*
Output:
——————————————————————
[9, 2, 3, 10, 7, 8, 4, 1, 6, 5]

*/

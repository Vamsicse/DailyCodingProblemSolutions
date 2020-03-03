import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * SumPair Problem
 * Approach: One-pass Hash Table
 * While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table.
 * If it exists, we have found a solution and return immediately.
 *
 * Time complexity : O(n). We traverse the list containing n elements only once. Each look up in table costs O(1) time.
 * Space complexity : O(n). Extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class SumPair {

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,4,5,2,0};
        int target = 4;
        System.out.println(Arrays.toString(new SumPair().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution is present in the input");
    }
}





/*
Output:
—————————

[2, 5]

*/

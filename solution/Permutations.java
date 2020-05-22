import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Find all permutations
 * Approach: Use Backtracking
 *
 * Time complexity : O(n*n!). There are n! permutations and it requires O(n) time to print a a permutation.
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class Permutations {

    List<List<Integer>> result;
    int[] nums;

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        System.out.println(obj.permute(new int[]{1,2,3}));
    }

    // Runtime:0ms, Memory:39.5MB
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        this.nums = nums;
        permute(0);
        return result;
    }

    void permute(int start) {
        //breaking condition when one permutation is complete
        if (start == nums.length) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int i  =0; i< nums.length; i++) l.add(nums[i]);
            result.add(l);
        }
        else {
            for (int i = start; i < nums.length; i++) {
                swap (i, start);
                permute(start+1);
                swap(i, start);
            }
        }
    }

    void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
Output:
——————————————————————

[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

*/

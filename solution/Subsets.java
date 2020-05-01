import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Generate power set
 * Approach: Use BackTrack
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class Subsets {

    public static void main(String[] args) {
        int[] set = {1,2,3};
        System.out.println("Power set for " + Arrays.toString(set) + " is: " + subsets(set));
    }

    // Runtime: 0ms, Memory-39.8 MB
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


}




/*
Output:
—————————————————————— 

Power set for [1, 2, 3] is: 
     
     [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]


*/

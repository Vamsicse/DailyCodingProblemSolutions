import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: Given array and target, find all unique combinations that sum up sum to target.
 *          LeetCode: 40
 * Approach: Backtracking with Index
 *           We iterate through the sorted input array, via backtracking to build the combinations.
 *           In addition, do some tricks with the index of the iteration, to avoid duplicated combinations.
 *
 * Time Complexity: O(2^n)
 * Auxiliary Space: O(N)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2020-12-27
 */
public class CombinationSumPossibilitiesList {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, comb, target, 0, results);
        return results;
    }

    private static void backtrack(int[] candidates, LinkedList<Integer> comb, Integer remain, Integer curr,
                           List<List<Integer>> results) {
        if (remain == 0) {
            // copy the current combination to the final list.
            results.add(new ArrayList<>(comb));
            return;
        }

        for (int nextCurr = curr; nextCurr < candidates.length; ++nextCurr) {
            if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1])
                continue;
            Integer pick = candidates[nextCurr];
            if (remain - pick < 0) // optimization: early stopping
                break;
            comb.addLast(pick);
            backtrack(candidates, comb, remain - pick, nextCurr + 1, results);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

}

/*
Output:
——————————————————————
[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
[[1, 2, 2], [5]]

*/
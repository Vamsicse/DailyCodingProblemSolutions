import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: BrickWall. LC: 554.
 *    A wall consists of several rows of bricks of various integer lengths and uniform height.
 *    Your goal is to find a vertical line going from the top to the bottom of the wall that cuts through the fewest number of bricks.
 *    If the line goes through the edge between two bricks, this does not count as a cut.
 * Approach: If the goal here is to find where a line will cross the fewest bricks, then we could also say that the goal is to find where the most brick edges line up.
 *    We can consider the edges to occur at an index representing the current running total of the previous elements of a given row of the wall.
 *    For example, if the row is defined as [1,2,2,1], then the inside edges occur at [1,1+2,1+2+2], or [1,3,5].
 *    If we now know how to find edges, then we're left with finding out which index has highest frequency of edges, which naturally calls for a frequency map.
 *    So we can iterate through each row in the wall, keep a running total of the current row (rowSum), and then update frequency of each edge's index in our frequency map (freq).
 *    Once we're done filling freq, we just need to iterate through it to find highest value (best), which represents number of edges aligned on a single index.
 *    Our actual answer, however, is number of bricks, not edges, so we should return the total number of rows minus best.
 *    It's faster to keep track of best as we add values to freq.
 *
 * Time complexity : O(mn)
 * Space Complexity: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2020-12-27
 */
public class BrickWall {

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        System.out.println(leastBricks(wall));
    }

    // Runtime: 4ms, Memory: 41.9 MB
    private static int leastBricks(List<List<Integer>> wall) {
        int best = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < wall.size(); i++)
            best = processRow(wall.get(i), freq, best);
        return wall.size() - best;
    }

    public static int processRow(List<Integer> row, Map<Integer, Integer> freq, int best) {
        int rowSum = row.get(0);
        for (int j = 1; j < row.size(); j++) {
            int f = freq.getOrDefault(rowSum, 0) + 1;
            freq.put(rowSum, f);
            if (f > best) best = f;
            rowSum += row.get(j);
        }
        return best;
    }

}

/*
Output:
-----------
2

 */

// https://leetcode.com/problems/brick-wall/discuss/1170889/JS-Python-Java-C%2B%2B-or-Easy-Frequency-Map-Solution-w-Explanation

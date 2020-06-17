import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Given a triangle, find min path sum from top to bottom. Each step we move to adjacent numbers on row below.
 * Approach: DP with memoization.
 *
 * Time Complexity: O(n.l)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class TriangleMinPathTopToBottom {

    public static void main(String[] args) {
        List<Integer> row1 = Arrays.asList(1);
        List<Integer> row2 = Arrays.asList(2,3);
        List<Integer> row3 = Arrays.asList(1,5,1);
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(row1); rows.add(row2); rows.add(row3);
        assert minimumTotal(rows)==4;
    }

    // Runtime: 1ms, Memory: 39.6MB
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty())
            return 0;
        int[] mem = new int[triangle.size() + 1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[1] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> list = triangle.get(i);
            int prev = mem[0];
            for(int j = 0; j < list.size(); j++){
                int tmp = mem[j + 1];
                mem[j + 1] = list.get(j) + Math.min(prev, mem[j + 1]);
                prev = tmp;
            }
        }
        int res = mem[1];
        for(int num : mem) res = Math.min(res, num);
            return res;
    }

}

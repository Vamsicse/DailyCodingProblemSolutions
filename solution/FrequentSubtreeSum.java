import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: Find most frequent subtree sum. LC: 508
 * Approach: DFS and HashMap to store frequency.
 *
 * Time complexity : O(n)
 * Space complexity : O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class FrequentSubtreeSum {

    private static int highFreq = 0;

    // Runtime: 2ms, Memory: 40MB
    public static int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList();
        HashMap<Integer,Integer> map = new HashMap();
        dfs(root, list, map);
        int [] res = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static int dfs(TreeNode node, List<Integer> list, HashMap<Integer,Integer> map) {
        if(node ==null)
            return 0;
        int left =  dfs(node.left, list, map);
        int right =   dfs(node.right, list, map);

        int sum = left + right + node.val;
        map.put(sum,  map.getOrDefault(sum,0)+1);

        if(map.get(sum)> highFreq)  {
            list.clear();
            list.add(sum);
            highFreq = map.get(sum);
        }
        else if(map.get(sum)== highFreq) {
            list.add(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(-3);
        System.out.println(Arrays.toString(findFrequentTreeSum(root1)));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(-5);
        System.out.println(Arrays.toString(findFrequentTreeSum(root2)));
    }

}

/*
Output:
——————————————————————
[2, -3, 4]
[2]

*/
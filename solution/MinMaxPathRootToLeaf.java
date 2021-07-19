import java.util.ArrayList;
import java.util.List;

/**
 * Problem: FInd min/max path from root to leaf
 * Approach: Recursion to find sum and BFS to find sum path
 *
 * Time complexity : O(n)
 * Space complexity : O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class MinMaxPathRootToLeaf {

    public static void main(String[] args) {
        /*
                  1
             2        3
                5
         */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        int minPathSum = minPathSum(root1), maxPathSum = maxPathSum(root1);
        System.out.println("Min Path Sum:" + minPathSum);
        System.out.println("Min Path: " + pathSum(root1, minPathSum));
        System.out.println("Max Path Sum:" + maxPathSum);
        System.out.println("Max Path: " + pathSum(root1, maxPathSum));
        System.out.println();
        /*
                     1
               2          3
                       4      5
         */
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        minPathSum = minPathSum(root2);
        maxPathSum = maxPathSum(root2);
        System.out.println("Min Path Sum:" + minPathSum);
        System.out.println("Min Path: " + pathSum(root2, minPathSum));
        System.out.println("Max Path Sum:" + maxPathSum);
        System.out.println("Max Path: " + pathSum(root2, maxPathSum));
    }

    public static int minPathSum(TreeNode root) {
        if(root == null) return 0;
        int sum = root.val;
        int leftSum = Integer.MAX_VALUE, rightSum = Integer.MAX_VALUE;
        if(root.right==null && root.left==null) {
            return sum;
        }else{
            if(root.left!=null){
                leftSum = minPathSum(root.left);
            }
            if (root.right!=null){
                rightSum = minPathSum(root.right);
            }
            if(leftSum < rightSum){
                sum += leftSum;
            }else{
                sum += rightSum;
            }
        }
        return sum;
    }

    public static int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int sum = root.val;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        if(root.right==null && root.left==null) {
            return sum;
        }else{
            if(root.left!=null){
                leftSum = maxPathSum(root.left);
            }
            if (root.right!=null){
                rightSum = maxPathSum(root.right);
            }
            if(leftSum > rightSum){
                sum += leftSum;
            }else{
                sum += rightSum;
            }
        }
        return sum;
    }

    // Runtime: 1ms, Memory: 39.4MB
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, 0, sum, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(TreeNode root, int prev, int sum, List<Integer> path, List<List<Integer>> result) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (prev == sum - root.val) {
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            dfs(root.left, prev + root.val, sum, path, result);
        }
        if (root.right != null) {
            dfs(root.right, prev + root.val, sum, path, result);
        }
        path.remove(path.size() - 1);
    }

}

/*
Output:
——————————————————————

Min Path Sum:4
Min Path: [[1, 3]]
Max Path Sum:8
Max Path: [[1, 2, 5]]

Min Path Sum:3
Min Path: [[1, 2]]
Max Path Sum:9
Max Path: [[1, 3, 5]]

*/
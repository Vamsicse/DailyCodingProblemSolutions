import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Find Maximum Level Sum of a Binary Tree
 * Approach: Use BFS
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class BinaryTreeMaxLevelSum {

    public static void main(String[] args) {
        TreeNode tree1Root = new TreeNode(1);
        tree1Root.left = new TreeNode(2);
        tree1Root.right = new TreeNode(3);
        tree1Root.left.right = new TreeNode(5);
        System.out.println(maxLevelSum(tree1Root));

        TreeNode tree2Root = new TreeNode(1);
        tree2Root.left = new TreeNode(2);
        tree2Root.right = new TreeNode(3);
        tree2Root.right.left = new TreeNode(4);
        tree2Root.right.right = new TreeNode(5);
        System.out.println(maxLevelSum(tree2Root));
    }

    // Runtime: 8ms, Memory: 41.4MB
    public static int maxLevelSum(TreeNode root) {
        int max_sum=Integer.MIN_VALUE;
        int max_lvl=0;
        int lvl=0;
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            lvl++;
            while(size--!=0){
                TreeNode rp=queue.poll();
                sum+=rp.val;
                if(rp.left!=null){
                    queue.add(rp.left);
                }
                if(rp.right!=null){
                    queue.add(rp.right);
                }
            }
            if(sum>max_sum){
                max_sum=sum;
                max_lvl=lvl;
            }
        }
        return max_lvl;
    }

}

/*

Output:
——————————————————————

2
3

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Given BT, return level order traversal of its nodes' values.
 * Approach: Populate all nodes in a level into a Queue.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class BinaryTreeLevelOrderTraversal {

       private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

   // Runtime: 0ms, Memory: 39.6MB
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> level=new ArrayList<>();
        while(queue.size()>0){
            root=queue.remove();
            while(queue.size()>0 && root!=null){
                level.add(root.val);
                if(root!=null){
                    if(root.left!=null)queue.add(root.left);
                    if(root.right!=null)queue.add(root.right);
                }
                root=queue.remove();
            }
            result.add(level);
            level=new ArrayList<>();
            if(queue.size()>0){
                queue.add(null);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(76);
        root.left = new TreeNode(32);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(100);
        root.right.right = new TreeNode(176);
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        System.out.println(obj.levelOrder(root));
    }

}

/*
Output:
——————————————————— 

[[76], [32, 100], [1, 176]]

*/

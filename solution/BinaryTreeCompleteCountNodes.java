/**
 * Problem: Given a complete binary tree, count the number of nodes.
 * Approach: Recursively count left and right nodes.
 *
 * Time Complexity: O(log(n))
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class BinaryTreeCompleteCountNodes {

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countNodes(TreeNode root) {
        return countNodes(root, 0);
    }

    int countNodes(TreeNode root, int count){
        if(root == null){
            return count;
        }
        ++count;
        count = countNodes(root.left, count);
        return countNodes(root.right, count);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(76);
        root.left = new TreeNode(25);
        root.right = new TreeNode(100);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(32);
        root.right.right = new TreeNode(176);
        BinaryTreeCompleteCountNodes obj = new BinaryTreeCompleteCountNodes();
        assert 6==obj.countNodes(root);
    }

}

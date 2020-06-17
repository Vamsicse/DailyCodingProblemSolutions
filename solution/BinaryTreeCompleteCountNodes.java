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

    int leafCount = 0;

    // Runtime: 0ms, Memory: 42MB
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int height = findTreeHeight(root,0);
        getLeafCount(root,height);
        int count = 0;
        for(int i=0; i<height; i++) {
            count += Math.pow(2,i);
        }
        return count + leafCount;
    }

    private void getLeafCount(TreeNode root, int depth) {
        if(root != null) {
            if(depth == 0) {
                leafCount++;
            }
            else {
                getLeafCount(root.left, depth-1);
                getLeafCount(root.right, depth-1);
            }
        }
    }

    private int findTreeHeight(TreeNode root, int height) {
        if(root == null) {
            return height;
        }
        if(root.left == null && root.right == null) {
            return height;
        }
        return Math.max(findTreeHeight(root.left, height+1), findTreeHeight(root.right, height+1));
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

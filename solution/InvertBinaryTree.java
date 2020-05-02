import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Invert Binary Tree
 * Approach: Swap left & right child of all nodes.
 *      So we create a queue to store nodes whose left and right child have not been swapped yet.
 *      Initially, only root is in queue. As long as queue is not empty, remove next node from queue, swap its children & add children to queue.
 *      Null nodes are not added to the queue. Eventually, queue will be empty and all children swapped, and we return original root.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class InvertBinaryTree {

    static class TreeNode {
        String val;
        TreeNode left, right;
        TreeNode(String val) {
            this.val = val;
        }
    }

    // Runtime: 0ms, Memory:37.1 MB
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("a");
        root.left = new TreeNode("b");
        root.right = new TreeNode("c");
        root.left.left = new TreeNode("d");
        root.left.right = new TreeNode("e");
        root.right.left = new TreeNode("f");

        TreeNode invertedTree = new InvertBinaryTree().invertTree(root);
        System.out.println(invertedTree.val);
        System.out.println(invertedTree.left.val);
        System.out.println(invertedTree.right.val);
    }

}


/*
Output:
——————————————————————

a
c
b

*/

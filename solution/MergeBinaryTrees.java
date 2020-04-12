/**
 * Problem: Merge 2 Binary Trees
 * Approach: Use Recursion.
 *
 * Time Complexity: O(m). A total of m nodes need to be traversed. Here, m represents minimum # of nodes from 2 given trees.
 * Space Complexity: O(m). The depth of recursion tree can go upto m in case of a skewed tree. In avg case, depth will be O(log m).
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class MergeBinaryTrees {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(76);
        node1.left = new TreeNode(32);
        node1.right = new TreeNode(100);
        node1.left.left = new TreeNode(5);

        TreeNode node2 = new TreeNode(4);
        node2.left = new TreeNode(3);
        node2.right = new TreeNode(5);

        TreeNode resultTreeNode = mergeTrees(node1, node2);
        System.out.println("Inorder traversal of merged tree is:");
        printInorder(resultTreeNode);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.data += t2.data;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { data = x; }
    }

    private static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

}



/*
Output:
—————————————————————— 

Inorder traversal of merged tree is:
5 35 80 105 


*/


/**
 * Problem: Implement BST Iterator.
 * Approach: Find the left-most node, extract its value, update the node in place to remove it from the tree.
 *
 * Time Complexity: O(1) for hasNext() and O(h) for next()
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class BSTIterator {

    private TreeNode head, node;

    public BSTIterator(TreeNode root) {
        linearizeTreeNode(root);
    }

    // Return next smallest number
    public int next() {
        int val = head.val;
        head = head.right;
        return val;
    }

    public boolean hasNext() {
        return null != head;
    }

    private void linearizeTreeNode(TreeNode root) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            linearizeTreeNode(root.left);
        }
        if (null == head) {
            head = root;
        }
        if(null == node) {
            node = root;
        } else {
            node.right = root;
            node = node.right;
        }
        if (null != root.right) {
            linearizeTreeNode(root.right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val; this.left = left; this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(32);
        TreeNode node2 = new TreeNode(76);
        TreeNode node3 = new TreeNode(100);
        TreeNode node4 = new TreeNode(81);

        node2.left = node1;
        node2.right = node3;
        node3.left = node4;

        BSTIterator bstIterator = new BSTIterator(node2);
        while(bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }

}


/*
Output:
———————————————————
32
76
81
100

*/

/**
 * Problem: Find if a given binary tree is a valid BST.
 * Approach: Keep a valid range from [MIN_VALUE, MAX_VALUE] & keep shrinking it down recursively for each node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class ValidateBinarySearchTree {

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static boolean isBST(Node node, int minKey, int maxKey) {
        if (node == null) {
            return true;
        }
        if (node.data < minKey || node.data > maxKey) {
            return false;
        }
        return isBST(node.left, minKey, node.data) &&
                isBST(node.right, node.data, maxKey);
    }

    public static void isBST(Node root) {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("Valid BST.");
        } else {
            System.out.println("Invalid BST!");
        }
    }

    private static void swap(Node root) {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }

    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        for (int key : keys) {
            root = insert(root, key);
        }

        // swap left and right nodes for testing
        swap(root);
        isBST(root);
    }

    private static class Node {
        int data;
        Node left = null, right = null;
        Node(int data) {
            this.data = data;
        }
    }
}

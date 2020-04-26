/**
 * Problem:  Find the deepest node in Binary Tree.
 * Approach: Find depth of the tree and then print the node at the bottom-most level.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class BinaryTreeDeepestNode {

    static class TreeNode {
       int data;
       TreeNode left, right;
       TreeNode(int x) { data = x; }
    }

    static void deepestNode(TreeNode root, int levels) {
        if(root == null){
            return;
        }
        if(levels == 1) {
            System.out.print(root.data + " ");
        }
        else if(levels > 1) {
            deepestNode(root.left, levels - 1);
            deepestNode(root.right, levels - 1);
        }
    }

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int maxDepth = maxDepth(root);
        System.out.println("Deepest node is: ");
        deepestNode(root, maxDepth);
    }

}




/*
Output:
—————————————————————— 

Deepest node is: 
4



*/


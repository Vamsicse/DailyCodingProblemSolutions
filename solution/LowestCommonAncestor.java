/**
 * Problem: LC:236. Lowest Common Ancestor of Binary Tree
 * Approach: Use Recursion.
 *      If the current (sub) tree contains both p and q, then the function result is their LCA.
 *      If only one of them is in that subtree, then the result is one of them.
 *      If neither are in that subtree, the result is null.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna
 * @version 1.0
 * @since 2020-12-27
 */
public class LowestCommonAncestor {

    public static void main(String... args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, root.left, root.right).val); // root, 5, 1
    }

    // Runtime: 7ms, Memory:47MB
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }


}
/*
Output:
——————————————————————

3

*/
/**
 * Problem: Find if a tree is height balanced. LC: 110
 * Approach: Use recursion
 *
 * Time complexity : O(n)
 * Space complexity : O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class BinaryTreeHeightBalanced {

    // Runtime: 1ms, Memory: 42MB
    public static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(maxHeight(root.left)-maxHeight(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int maxHeight(TreeNode root){
        if(root==null) return 0;
        int l = maxHeight(root.left)+1;
        int r = maxHeight(root.right)+1;
        return Math.max(l,r);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(76);
        root.left = new TreeNode(32);
        root.left.left = new TreeNode(10);
        root.right = new TreeNode(100);
        root.right.right = new TreeNode(176);
        System.out.println(isBalanced(root));

        root.left.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);
        System.out.println(isBalanced(root));
    }
}

/*
Output:
——————————————————————
true
false

*/
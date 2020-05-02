import java.util.HashMap;

/**
 * Problem: Given preorder and inorder traversal of a tree, construct the binary tree.
 * Approach: Use BackTracking
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class ConstructBTFromPreorderInorder {

    private int preIndex = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Runtime: 1ms, Memory: 39.5 MB
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return traverse(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode traverse(int[] preorder, int[] inorder, int inStart, int inEnd){
        if(preIndex > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int currentInIndex = map.get(root.val);
        root.left = traverse(preorder, inorder, inStart, currentInIndex - 1);
        root.right = traverse(preorder, inorder, currentInIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = { 76, 25,  1, 32, 100 };
        int[] inOrder  = {  1, 25, 32, 76, 100 };
        TreeNode root = new ConstructBTFromPreorderInorder().buildTree(preOrder, inOrder);
        System.out.println(root.val);
    }

}


/*
Output:
—————————————————————— 

76


*/

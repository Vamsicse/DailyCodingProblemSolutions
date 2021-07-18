/**
 * Problem: Find largest BST subtree in a given Binary Tree
 * Approach: Recursion. While visiting each node keep track of size of largest BST so far
 *
 * Time complexity : O(n)
 * Space complexity : O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class LargestBSTSubtree {

    public static void main(String[] args) {
        /*
                  10
              5        15
            1   8          7
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println(largestBSTSubtree(root));
    }

    public static int largestBSTSubtree(TreeNode root) {
        Node n = isBST(root);
        return n.size;
    }

    static Node isBST(TreeNode root){
        Node node = new Node();
        if(root == null){
            return node;
        }

        Node l = isBST(root.left);
        Node r = isBST(root.right);

        node.left = Math.min(l.left, root.val);
        node.right = Math.max(r.right, root.val);

        if(l.isBst && r.isBst && l.right <= root.val && r.left >= root.val){
            node.size = l.size + r.size +1;
            node.isBst = true;
        }else{
            node.size = Math.max(l.size, r.size);
            node.isBst = false;
        }
        return node;
    }

    static class Node{
        int size;
        int left,right;
        boolean isBst;
        Node(){
            size = 0;
            isBst = true;
            left = Integer.MAX_VALUE;
            right = Integer.MIN_VALUE;
        }
    }

}

/*
Output:
——————————————————————

3

*/
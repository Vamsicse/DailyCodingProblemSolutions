/**
 * Problem: Print Left, Right View of Binary Tree.  Array Representation: [12,10,30,_,_,25,40]
 * Approach: Use recursion while incrementing through levels of tree
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class BinaryTreeView {

    public static void main(String args[]) {

        BTNode root = new BTNode(12);
        root.left = new BTNode(10);
        root.right = new BTNode(30);
        root.right.left = new BTNode(25);
        root.right.right = new BTNode(40);

        BinaryTree binaryTree = new BinaryTree(root);
        System.out.println("\nLeft View is: ");
        binaryTree.leftView(root, 1);

        binaryTree = new BinaryTree(root);
        System.out.println("\nRight View is: ");
        binaryTree.rightView(root, 1);
    }

    static class BinaryTree {
        BTNode root;
        int max_level = 0;
        BinaryTree(BTNode node){
            root = node;
        }

        void leftView(BTNode node, int level) {
            if (node == null) {
                return;
            }
            if (max_level < level) { // If this is first node of its level
                System.out.print(" " + node.data);
                max_level = level;
            }
            // Recur for left and right subtrees
            leftView(node.left, level + 1);
            leftView(node.right, level + 1);
        }

        void rightView(BTNode node, int level) {
            if (node == null) {
                return;
            }
            if (max_level < level) { // If this is first node of its level
                System.out.print(" " + node.data);
                max_level = level;
            }
            // Recur for left and right subtrees
            rightView(node.right, level + 1);
            rightView(node.left, level + 1);
        }
    }

    static class BTNode {
        int data;
        BTNode left, right;

        public BTNode(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

}







/*
Output:
—————————————————————— 

Left View is: 
 12 10 25

Right View is: 
 12 30 40 25 10

*/

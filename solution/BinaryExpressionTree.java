/**
 * Problem: Given Binary tree expression evaluate it.
 * Approach: Use recursion
 *
 * Time complexity : O(n)
 * Space Complexity: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2020-12-27
 */
public class BinaryExpressionTree {

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static double process(String op, double x, double y) {
        if (op == "+") { return x + y; }
        if (op == "-") { return x - y; }
        if (op == "*") { return x * y; }
        if (op == "/") { return x / y; }
        return 0;
    }

    public static double evaluate(Node root) {
        if (null == root) {
            return 0;
        }
        if (isLeaf(root)) { // the leaves of a binary expression tree are operands
            return Integer.valueOf(root.val);
        }
        // recursively evaluate left and right subtree
        double x = evaluate(root.left);
        double y = evaluate(root.right);
        return process(root.val, x, y); // apply operator at root to values obtained in previous step
    }

    public static void main(String[] args) {
        Node root = new Node("+");
        root.left = new Node("*");
        root.right = new Node("/");
        root.left.left = new Node("-");
        root.left.right = new Node("5");
        root.right.left = new Node("21");
        root.right.right = new Node("7");
        root.left.left.left = new Node("10");
        root.left.left.right = new Node("5");
        System.out.println("The value of the expression tree is " + evaluate(root));

        Node root2 = new Node("*");
        root2.left = new Node("+");
        root2.right = new Node("+");
        root2.left.left = new Node("3");
        root2.left.right = new Node("2");
        root2.right.left = new Node("4");
        root2.right.right = new Node("5");
        System.out.println("The value of the expression tree is " + evaluate(root2));
    }

    static class Node {
        String val;
        Node left, right;
        Node(String val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}

/*
Output:
—————————
The value of the expression tree is 28.0
The value of the expression tree is 45.0

*/

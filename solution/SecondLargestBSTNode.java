/**
 * Problem: Find second largest node in BST.
 * Approach: Recursion. Use a counter to find node at last but 1 level.
 * Time Complexity: O(h), where 'h' is height of the tree
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class SecondLargestBSTNode {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
              50
           /     \
          30      76
         /  \    /  \
       10   40  60   81 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(10);
        tree.insert(40);
        tree.insert(76);
        tree.insert(60);
        tree.insert(81);

        tree.secondLargest();
    }

    static class BinarySearchTree {
        Node root;
        BinarySearchTree() {
            root = null;
        }

        public void insert(int data) {
            this.root = this.insertRec(this.root, data);
        }

        Node insertRec(Node node, int data) {
            if (node == null) {
                this.root = new Node(data);
                return this.root;
            }
            if (data < node.data) {
                node.left = this.insertRec(node.left, data);
            } else {
                node.right = this.insertRec(node.right, data);
            }
            return node;
        }

        public class count {
            int c = 0;
        }

        void secondLargestUtil(Node node, count C) {
            if (node == null || C.c >= 2) {
                return;
            }
            this.secondLargestUtil(node.right, C);
            C.c++;  // Increment count of visited nodes
            if (C.c == 2) {
                System.out.print("2nd largest element is " + node.data);
                return;
            }
            this.secondLargestUtil(node.left, C);
        }

        void secondLargest() {
            count C = new count();
            this.secondLargestUtil(this.root, C);
        }
    }

    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

}



/*
Output:
—————————————————————— 

2nd largest element is 76


*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversals {

    private void printPostorder(TreeNode node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.val + " ");
    }

    private void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    private void printPreorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    // Runtime: 0ms, Memory: 39.1MB
    // Time Complexity: O(n), Space Complexity: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = q.poll();
                list.add(pop.val);
                if (pop.left != null)
                    q.offer(pop.left);
                if (pop.right != null)
                    q.offer(pop.right);
            }
            result.add(list);
        }
        return result;
    }

    // Runtime: 0ms, Memory: 39.1MB
    // Time Complexity: O(n), Space Complexity: O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = true;
        while (!q.isEmpty()) {
            reverse = !reverse;

            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = q.poll();
                if (reverse) {
                    list.addFirst(pop.val);
                } else {
                    list.add(pop.val);
                }
                if (pop.left != null)
                    q.offer(pop.left);
                if (pop.right != null)
                    q.offer(pop.right);
            }
            result.add(list);
        }
        return result;
    }


}

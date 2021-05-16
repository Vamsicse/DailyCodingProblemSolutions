import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given BT, return all the paths from root to leaves.
 * Approach: Use recursion to traverse all paths.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode tree1Root = new TreeNode(1);
        tree1Root.left = new TreeNode(2);
        tree1Root.right = new TreeNode(3);
        tree1Root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(tree1Root));

        TreeNode tree2Root = new TreeNode(1);
        tree2Root.left = new TreeNode(2);
        tree2Root.right = new TreeNode(3);
        tree2Root.right.left = new TreeNode(4);
        tree2Root.right.right = new TreeNode(5);
        System.out.println(binaryTreePaths(tree2Root));
    }

    // Runtime: 1ms, Memory: 38.7MB
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        path(root, list, new StringBuilder());
        return list;
    }

    private static void path(TreeNode root, List<String> list, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
            int len = sb.length();
            if (root.left == null && root.right == null) {
                list.add(sb.toString());
            } else {
                path(root.left, list, sb.append("->"));
                sb.delete(len,sb.length());
                path(root.right, list, sb.append("->"));
            }
        }
    }

}

/*
Output:
———————————————————

[1->2->5, 1->3]
[1->2, 1->3->4, 1->3->5]

*/

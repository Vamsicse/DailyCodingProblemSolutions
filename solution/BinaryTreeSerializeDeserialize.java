import java.util.StringTokenizer;

/**
 * Problem: Serialize and Deserialize Binary Tree
 * Approach: Recursively build left and right trees
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
 
// Runtime: 8ms, Memory: 41.1MB
public class BinaryTreeSerializeDeserialize {

    private static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int x) { data = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        sHelper(root, builder);
        return builder.toString();
    }

    private void sHelper(TreeNode root, StringBuilder builder) {
        if(root == null) {
            builder.append("# ");
            return;
        }
        builder.append(root.data + " ");
        sHelper(root.left, builder);
        sHelper(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer tokenizer = new StringTokenizer(data);
        return dHelper(tokenizer);
    }

    private TreeNode dHelper(StringTokenizer tokenizer) {
        if(tokenizer.hasMoreElements()) {
            String next = tokenizer.nextToken();
            if(next.equals("#")) {
                return null;
            }else{
                TreeNode curr = new TreeNode(Integer.parseInt(next));
                curr.left = dHelper(tokenizer);
                curr.right = dHelper(tokenizer);
                return curr;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        BinaryTreeSerializeDeserialize obj = new BinaryTreeSerializeDeserialize();

        TreeNode node76 = new TreeNode(76);
        TreeNode node32 = new TreeNode(32);
        TreeNode node1 = new TreeNode(1);
        TreeNode node100 = new TreeNode(100);

        node76.left = node32;
        node32.left = node1;
        node76.right = node100;

        System.out.println(obj.serialize(node76));
    }

}

/*
Output:
——————————————————————

76 32 1 0 # # # # 100 # #

*/

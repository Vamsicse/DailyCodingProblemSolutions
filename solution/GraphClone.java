import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: Clone a graph.
 * Approach: Use DFS. DFS requires lower memory than BFS, since it doesn't store all of the child pointers at each level.
 *
 * Time Complexity: O(V+E)
 * Space Complexity: O(V)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class GraphClone {

    private HashMap<Node, Node> nodeMap = new HashMap<>();

    // Approach: DFS, Runtime: 26ms, Memory: 39.2MB
    public Node cloneGraphUsingDFS(Node node) {
        if(null==node) return null;
        nodeMap.put(node, new Node(node.val, new ArrayList<>()));
        for(Node neighbor: node.neighbors){
            if(nodeMap.containsKey(neighbor)){
                nodeMap.get(node).neighbors.add(nodeMap.get(neighbor));
            }else{
                nodeMap.get(node).neighbors.add(cloneGraphUsingDFS(neighbor));
            }
        }
        return nodeMap.get(node);
    }

    public static void main(String[] args) {
     /*
         1  -- 32
         |     |
        100 -- 76
     */

        Node a = new Node(1);
        Node b = new Node(32);
        Node c = new Node(76);
        Node d = new Node(100);

        a.neighbors = new ArrayList<>(Arrays.asList(b,d));
        b.neighbors = new ArrayList<>(Arrays.asList(a,c));
        c.neighbors = new ArrayList<>(Arrays.asList(b,d));
        d.neighbors = new ArrayList<>(Arrays.asList(a,c));

        GraphClone obj = new GraphClone();
        Node cloneNode = obj.cloneGraphUsingDFS(a);

    }

    // Approach: BFS, Runtime: 27ms, Memory: 39.9MB
    public Node cloneGraphUsingBFS(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node h = queue.poll();
            for (Node neighbor : h.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(h).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

}

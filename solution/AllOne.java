import java.util.HashMap;
import java.util.HashSet;

/**
 * Problem: Create a DS that performs all the following operations in O(1) time.
 *        add, remove, get_max, get_min
 * Approach: HashMap and LinkedList
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */

// Runtime: 42ms, Memory: 55.4 MB
public class AllOne {

    private HashMap<String, Node> map;
    private Node head, tail;

    // Initialize data structure
    public AllOne() {
        map = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    /** Inserts new key with value 1 or increment existing key by 1. */
    public void inc(String key) {
        Node node = map.get(key);
        if (node == null) { // not exist, insert
            Node first = head.next;
            if (isEmptyList() || first.value != 1) { // list empty or value 1 node not exist
                first = insertNode(head, 1);
            }
            updateKey(first, key);
        } else { // exist, increment
            int value = node.value  + 1;
            // remove from current node, insert to next node
            Node next = node.next;
            if (value < next.value) { // next node value equal to new value, insert, or create new node
                next = insertNode(node, value);
            }
            removeKey(node, key);
            updateKey(next, key);
        }
    }

    // Decrement existing key by 1. If Key's value is 1, remove it
    public void dec(String key) {
        Node node = map.get(key);
        if (node == null) return;
        if (node.value == 1) { // remove
            map.remove(key);
            removeKey(node, key);
        } else { // decrement
            int value = node.value  - 1;
            Node prev = node.prev;  // remove from current node, insert to next node
            if (value > prev.value) { // prev node value equal to new value, insert, or create new node
                prev = insertNode(prev, value);
            }
            removeKey(node, key);
            updateKey(prev, key);
        }
    }

    // Returns one of the keys with maximal value.
    public String getMaxKey() {
        return isEmptyList() ? "" : tail.prev.keys.iterator().next();
    }

    // Returns one of the keys with Minimal value
    public String getMinKey() {
        return isEmptyList() ? "" : head.next.keys.iterator().next();
    }

    // Insert new node after prev node
    private Node insertNode(Node prev, int value) {
        Node node = new Node(value);
        node.keys = new HashSet<>();
        link(prev, node);
        return node;
    }

    // Remove key from node key set
    private void removeKey(Node node, String key) {
        node.keys.remove(key);
        if (node.keys.isEmpty()) unlink(node);
    }

    private void updateKey(Node node, String key) {
        node.keys.add(key);
        map.put(key, node);
    }

    private boolean isEmptyList() {
        return (head.next == tail) && (tail.prev == head);
    }

    private void link(Node prev, Node node) {
        Node next = prev.next;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int value;
        HashSet<String> keys;
        Node prev, next;
        Node(int value) {this.value = value;}
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("foo");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("bar");
        allOne.inc("bar");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.dec("bar");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }

}

/*
Output:
——————————————————————
foo
foo
bar
foo
bar
bar
——————————————————————
 */

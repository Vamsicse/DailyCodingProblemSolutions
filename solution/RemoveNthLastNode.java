// Delete Nth node from the end of the given linked list

/**
 * Problem: Delete Nth node from the end of the given linked list
 *
 * Approach: Take two pointers, first will point to the head of the linked list and second will point to the Nth node from the beginning.
 * Now keep increment both the pointers by one at the same time until second is pointing to the last node of the linked list.
 * After the operations from the previous step, first pointer should be pointing to the Nth node from the end by now.
 * So, delete the node first pointer is pointing to.
 *
 * Time Complexity: O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class RemoveNthLastNode {

    public static void main(String[] args) {
        Node node = new Node(76);
        node.next = new Node(32);
        node.next.next = new Node(176);
        node.next.next.next = new Node(276);
        traverse(node);
        int n=2;
        System.out.println("Removing node " + n + " from end.");
        removeNthFromEnd(node, n);
        traverse(node);
        n=1;
        System.out.println("Removing node " + n + " from end.");
        removeNthFromEnd(node, n);
        traverse(node);
    }

    private static void traverse(Node node){
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}

class Node {
    int data;
    Node next;
    Node(int x) { data = x; }
}


/*
Output:
-----------------------------------
76
32
176
276

Removing node 2 from end.
76
32
276

Removing node 1 from end.
76
32


*/

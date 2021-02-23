/**
 * Problem: Reverse nodes in Linked List.
 * Approach: While traversing each node, make that node tail of previous nodes.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: 1
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
           Node head = new Node(76);  // 76->32->100->176->1
           head.next = new Node(32);
           head.next.next = new Node(100);
           head.next.next.next = new Node(176);
           head.next.next.next.next = new Node(1);
           printNodes(reverseLinkedList(head));
    }

    // Iterative Approach [Time-0ms, Memory-40.3MB]
    private static Node reverseLinkedList(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // Iteratively reverse a linked list from position `m` to `n`
    public static Node reverseRange(Node head, int m, int n) {
        Node curr = head, prev = null;
        for (int i = 1; curr != null && i < m; i++) { // 1. Skip first `m` nodes
            prev = curr;
            curr = curr.next;
        }
        Node start = curr, end = null;  // prev now points to (m-1)'th node 'curr' now points to m'th node
        // 2. Traverse and reverse the sublist from position `m` to `n`
        for (int i = 1; curr != null && i <= n - m + 1; i++) {
            Node next = curr.next; // Take note of the next node
            curr.next = end;  // move the current node onto the `end`
            end = curr;
            curr = next;  // move to the next node
        }
        // `start` points to m'th node, 'end' now points to n'th node 'curr' now points to the (n+1)'th node
        // 3. Fix the pointers and return the head node
        start.next = curr;
        if (prev != null) {
            prev.next = end;
        } else {                // when `m = 1` (`prev` is null)
            head = end;
        }
        return head;
    }

    private static void printNodes(Node head){
        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

}



/*  Recursive approach [Time-0ms, Memory-39.8MB]
 public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    } 
*/



/*
Output:
—————————————————————— 

1
176
100
32
76



*/

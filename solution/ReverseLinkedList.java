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

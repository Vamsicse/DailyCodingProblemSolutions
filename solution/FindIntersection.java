import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Find Intersection point.
 * Approach: Use HashTable
 *
 * Time Complexity: O(m+n)
 * Space Complexity: O(m) or O(n) whichever is bigger
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class FindIntersection {

    static class LinkedList {
        static ListNode head1, head2;
    }

    static class ListNode {
      Integer val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof ListNode)) {
                return false;
            }
            ListNode c = (ListNode) o;
            return val==c.val && next == c.next;
        }
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + (this.val != null ? this.val.hashCode() : 0);
            return hash;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // creating first linked list
        list.head1 = new ListNode(3);
        list.head1.next = new ListNode(6);
        list.head1.next.next = new ListNode(9);
        list.head1.next.next.next = new ListNode(15);
        list.head1.next.next.next.next = new ListNode(30);

        // creating second linked list
        list.head2 = new ListNode(10);
        list.head2.next = new ListNode(15);
        list.head2.next.next = new ListNode(30);

        System.out.println("Intersection node is: " + getIntersectionNode(list.head1, list.head2));
    }

    /*
    public static ListNode getIntersectionNode(ListNode n1, ListNode n2) {
        Set<ListNode> chain = new HashSet<>();
        while(null!=n1){
            chain.add(n1);
            n1 = n1.next;
        }
        while(null!=n2){
            if(chain.contains(n2)){
                return n2;
            }
            n2 = n2.next;
        }
        return null;
    } */
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA, n2 = headB;
        while (n1.val!=n2.val) {
            n1 = (n1 != null) ? n1.next : headB;
            n2 = (n2 != null) ? n2.next : headA;
        }
        return n1;
    }
    

}



/*
Output:
—————————————————————— 

Intersection node is: 30


*/

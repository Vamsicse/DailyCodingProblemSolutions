import com.sun.nio.sctp.SctpSocketOption;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Given head of a singly linked list, where each node also has a 'random' pointer that points to anywhere in linked list, deep clone the list.
 * Approach: Recursive deep copy.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class CloneLinkedListWithRandomPointer {

    Map<Node,Node> maps ;

    public static void main(String[] args) {
        CloneLinkedListWithRandomPointer obj = new CloneLinkedListWithRandomPointer();
        Node head = new Node(32);
        head.next = new Node(76);
        head.next.next = new Node(100);
        head.random =  head.next.next;
        printList(head);
        Node head2 = obj.copyRandomList(head);
        printList(head2);
    }

    public Node copyRandomList(Node head) {
        maps = new HashMap<>();
        return deepCopy(head);
    }

    public Node deepCopy(Node head){
        if(head == null){
            return null;
        }
        if(maps.containsKey(head)){
            return maps.get(head);
        }
        Node copy = new Node(head.val);
        maps.put(head,copy);
        copy.next = deepCopy(head.next);
        copy.random = deepCopy(head.random);
        return copy;
    }

    private static void printList(Node head) {
        System.out.println("********");
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("********");
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString(){
            return "Val: " + val + " Next: " + next + " Random: " + random;
        }
    }

}


/*
Output:
—————————————————————— 

********
32
76
100
********
********
32
76
100
********


*/

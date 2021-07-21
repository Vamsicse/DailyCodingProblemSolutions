/**
 * Problem: Given a linked list and a positive integer k, rotate the list to the right by k places.
 * Approach: We can optimize the solution by finding (n-k)th element which is going to be the starting element.
 *           First we find the length of the list as n and make the list as a circular linked list.
 *           So to perform rotation on linked list, we first find (n-k-1)th element whose next element would be (n-k).
 *           Now set (n-k) as result(or head) and (n-k-1)'s next as null to break the loop of circular linked list.
 *
 * Time complexity : O(n)
 * Space complexity : O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class LinkedListRotate {

    // Runtime: 0ms, Memory: 38.7MB
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = head;
        if(head == null || head.next == null)
            return head;
        int n = 1; // Start from 1 to include last element
        while(dummy.next!=null){
            dummy = dummy.next;
            n++;
        }
        dummy.next = head; //Set last node to head to form circular list
        dummy = head;
        // Rotating n*a times would just give same list so remove them
        k = k%n;
        //  Since we rotate right we have to find (n-k)th element which is head
        for(int i = 0;i<n-k-1;i++){
            dummy = dummy.next;
        }
        //Break cycle by keeping head as (n-k) & setting (n-k-1)th element as tail
        head = dummy.next;
        dummy.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        ListNode res = rotateRight(head,2);
        while(res!=null){
            System.out.print(res.val + "\t");
            res=res.next;
        }
        System.out.println();
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        res = rotateRight(head2,3);
        while(res!=null){
            System.out.print(res.val + "\t");
            res=res.next;
        }
    }

}

/*
Output:
——————————————————————
3	5	7	7
3	4	5	1	2

*/
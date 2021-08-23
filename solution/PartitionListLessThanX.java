/**
 * Problem: Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *    You should preserve the original relative order of the nodes in each of the two partitions.
 * Approach: Intuition. Populate values less than x to r1 and values greater than x to r2. Merge nodes after segregation.
 *
 * Time complexity : O(n)
 * Space Complexity: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2020-12-27
 */
public class PartitionListLessThanX {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);
        ListNode.print(partition(l1, 3));

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(8);
        l2.next.next.next = new ListNode(0);
        l2.next.next.next.next = new ListNode(3);
        ListNode.print(partition(l2, 3));
    }

    // Runtime: 0ms, Memory: 38.3MB
    private static ListNode partition(ListNode head, int x) {
        ListNode r1 = new ListNode(0);
        ListNode pointer1 = r1;
        ListNode r2 = new ListNode(0);
        ListNode pointer2 = r2;
        while (head != null){
            if (head.val < x){
                r1.next = new ListNode(head.val);
                r1 = r1.next;
            }
            else {
                r2.next = new ListNode(head.val);
                r2 = r2.next;
            }
            head = head.next;
        }
        r1.next = pointer2.next;
        return pointer1.next;
    }

}

/*
Output:
—————————
******************************************************************
1->2->2->4->3->5
******************************************************************
******************************************************************
1->0->5->8->3
******************************************************************

 */

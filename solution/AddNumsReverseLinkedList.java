/**
 * Problem: Given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
 *      Add the two numbers and return the sum as a linked list.
 *      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Approach: Intuition. Add individual nodes and maintain carry over.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(l1 or l2) whichever is bigger
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class AddNumsReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode.print(addTwoNumbers(l1,l2));
    }

    // Runtime: 1ms, Memory: 39.5 MB
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tempResult = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carryOver = 0;
        while (temp1 != null || temp2 != null) {
            int val = carryOver;
            if(temp1!=null){
                val+=temp1.val;
                temp1 = temp1.next;
            }
            if(temp2!=null){
                val+=temp2.val;
                temp2 = temp2.next;
            }
            carryOver = val/10;
            val = val%10;
            if(result==null){
                result = new ListNode(val);
                tempResult = result;
            }else{
                tempResult.next = new ListNode(val);
                tempResult = tempResult.next;
            }
        }
        if(carryOver>0)
            tempResult.next = new ListNode(carryOver);

        return result;
    }

}


/*
Output:
——————————————————————
7->0->8
——————————————————————
 */

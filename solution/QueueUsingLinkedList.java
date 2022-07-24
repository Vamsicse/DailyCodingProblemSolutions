/**
 * Problem: Implement Queue using Linked List
 * Approach:
 *
 * Time complexity : Push: O(1), Pop: O(n), Peek: O(n)
 * Space complexity : O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class QueueUsingLinkedList {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1); q.enqueue(2); q.enqueue(3); q.enqueue(4);

        System.out.printf("The front element is %d\n", q.peek());

        q.dequeue(); q.dequeue(); q.dequeue(); q.dequeue();
    }

    private static class Queue {
        private static Node rear = null, front = null;
        private static int count = 0;

        public static int dequeue() {
            if (front == null) {
                System.out.println("\nQueue Underflow"); return -1;
            }
            Node temp = front;
            System.out.printf("Removing %d\n", temp.data);
            front = front.next;
            if (front == null) {
                rear = null;
            }
            count--;
            return temp.data;
        }

        public static void enqueue(int item) {
            Node node = new Node(item);
            System.out.printf("Inserting %d\n", item);
            if (front == null) { // initialize both front and rear
                front = node;
            }
            else {
                rear.next = node;
            }
            rear = node;
            count++;
        }

        public static int peek() {
            if (front == null) {
                System.exit(-1);
            }
            return front.data;
        }

        private static int size() {
            return count;
        }

    }

}

/*
Output:
——————————————————————
Inserting 1
Inserting 2
Inserting 3
Inserting 4
The front element is 1
Removing 1
Removing 2
Removing 3
Removing 4

*/

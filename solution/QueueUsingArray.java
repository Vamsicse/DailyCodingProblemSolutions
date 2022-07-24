/**
 * Problem: Implement Queue using Array
 *
 * @author  Vamsi Krishna
 * @since   2021-05-13
 */
public class QueueUsingArray {

    private static class Queue {
        private int front, rear, CAPACITY, currentSize;
        private int[] queueArray;

        public Queue(int size) {
            this.CAPACITY = size;
            this.queueArray = new int[size];
            front = 0;
            rear = -1;
            currentSize = 0;
        }

        public void insert(int item) {
            if (CAPACITY == currentSize) {
                System.out.println("Queue is full!");
                return;
            }
            if (rear == CAPACITY - 1) {
                rear = -1;
            }
            queueArray[++rear] = item;
            currentSize++;
            System.out.println("Item added to queue: " + item);
        }

        public int delete() {
            if (isQueueEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            int temp = queueArray[front++];
            if (front == CAPACITY) {
                front = 0;
            }
            currentSize--;
            return temp;
        }

        public int peek() {
            return queueArray[front];
        }

        public boolean isQueueEmpty() {
            return (currentSize == 0);
        }

        public static void main(String[] args) {
            Queue queue = new Queue(10);
            queue.insert(2);
            queue.insert(3);
            System.out.println("Item deleted from queue: " + queue.delete());
            System.out.println("Item deleted from queue: " + queue.delete());
            queue.insert(5);
            System.out.println("Item deleted from queue: " + queue.delete());
        }
    }
}
/*
Output:
——————————————————————
Item added to queue: 2
Item added to queue: 3
Item deleted from queue: 2
Item deleted from queue: 3
Item added to queue: 5
Item deleted from queue: 5

*/

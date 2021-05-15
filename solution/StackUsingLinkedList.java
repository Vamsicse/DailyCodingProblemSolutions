/**
 * Problem: Implement Stack
 * Approach: Use Linked List approach
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */

public class StackUsingLinkedList {

    public static void main(String[] args)
    {
        Stack obj = new Stack();
        // insert Stack value
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);

        obj.display();

        System.out.printf("\nTop element is %d\n", obj.peek());

        obj.pop();
        obj.pop();

        obj.display();

        System.out.printf("\nTop element is %d\n", obj.peek());
    }

    static class Stack {

        private class Node {
            int data;
            Node link;
        }

        Node top;

        Stack() {
            this.top = null;
        }

        public void push(int x) {
            // create new node temp and allocate memory
            Node temp = new Node();

            if (temp == null) {
                System.out.print("\nHeap Overflow");
                return;
            }
            temp.data = x;
            temp.link = top;
            top = temp;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int peek() {
            if (!isEmpty()) {
                return top.data;
            }
            else {
                System.out.println("Stack is empty");
                return -1;
            }
        }

        public int max(){
            if(null==top){
                throw new RuntimeException("Stack is Empty");
            }
            Node temp = top;
            while(temp.link != null){
                temp = temp.link;
            }
            return temp.data;
        }

        public void pop() {
            if (top == null) {
                System.out.print("\nStack Underflow");
                return;
            }
            top = (top).link;
        }

        public void display() {
            if (top == null) {
                System.out.printf("\nStack Underflow");
                System.exit(1);
            }
            else {
                Node temp = top;
                while (temp != null) {
                    System.out.printf("%d->", temp.data);
                    temp = temp.link;
                }
            }
        }

    }

}


/*
Output:
———————————————————

44->33->22->11->
Top element is 44
22->11->
Top element is 22

*/

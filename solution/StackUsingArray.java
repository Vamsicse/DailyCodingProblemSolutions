/**
 * Problem: Implement Stack Using Array
 * Approach: Use Array. Keep track of size for each operation.
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */

public class StackUsingArray {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(11);
        stack.push("hi");    stack.push("there");
        System.out.println(stack);
        stack.pop();    System.out.println(stack);
        stack.pop();    System.out.println(stack);
    }

    private static class Stack<E> {
        private E[] arr;
        private int CAPACITY, top = -1, size = 0;

        @SuppressWarnings("unchecked")
        public Stack(int cap) {
            this.CAPACITY = cap;    this.arr = (E[]) new Object[cap];
        }

        public E pop() {
            if (this.size == 0) {
                return null;
            }
            this.size--;
            E result = this.arr[top];
            this.arr[top] = null; //prevent memory leaking
            this.top--;
            return result;
        }

        public boolean push(E e) {
            if (this.size == this.CAPACITY)
                return false;
            this.size++;
            this.arr[++top] = e;
            return true;
        }

        public String toString() {
            if (this.size == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.size; i++) {
                sb.append(this.arr[i] + ", ");
            }
            sb.setLength(sb.length() - 2);
            return sb.toString();
        }
    }
}

/*
Output:
———————————————————
hi, there
hi
null

*/

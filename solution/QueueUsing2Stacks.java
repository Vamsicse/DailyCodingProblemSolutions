import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        int choice=0;

        while (choice!=4) {
            System.out.println("1.Enqueue 2.Dequeue 3.Peek 4.Exit");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Enter element to Enqueue");
                one.push(in.nextInt());
            }
            else if(choice == 2) {
                if(two.isEmpty()) {
                    while(!one.isEmpty()) {
                        two.push(one.pop());
                    }
                }
                if(two.isEmpty()){
                    System.out.println("Queue is Empty");
                }else {
                    two.pop();
                }
            }
            else if(choice == 3) {
                if(two.isEmpty()) {
                    while(!one.isEmpty()) {
                        two.push(one.pop());
                    }
                }
                if(two.isEmpty()){
                    System.out.println("Queue is Empty");
                }else {
                    System.out.println(two.peek());
                }
            }
        }
    }

}

/*
Output:
——————————————————————

1.Enqueue 2.Dequeue 3.Peek 4.Exit
2
Queue is Empty
1.Enqueue 2.Dequeue 3.Peek 4.Exit
3
Queue is Empty
1.Enqueue 2.Dequeue 3.Peek 4.Exit
1
Enter element to Enqueue
76
1.Enqueue 2.Dequeue 3.Peek 4.Exit
3
76
1.Enqueue 2.Dequeue 3.Peek 4.Exit
2
1.Enqueue 2.Dequeue 3.Peek 4.Exit
3
Queue is Empty
1.Enqueue 2.Dequeue 3.Peek 4.Exit
2
Queue is Empty
1.Enqueue 2.Dequeue 3.Peek 4.Exit

4

*/

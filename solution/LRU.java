import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Problem: Implement LRU
 * Approach: Use Queue and HashMap
 * While we iterate through elements find lowest buying point and then highest selling point.
 *
 * We can use Java inbuilt Deque as a double ended queue to store the cache keys, with
 * the descending time of reference from front to back and a set container to check presence
 * of a key. But remove a key from the Deque using remove(), it takes O(N) time. This can be
 * optimized by storing a reference (iterator) to each key in a hash map.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class LRU {
    private static Deque<Integer> dq = new LinkedList<>();
    private static HashSet<Integer> map = new HashSet<>();
    private static int cacheSize = 4;

    private static void set(int x) {
        System.out.println("\n" + "SET:  Storing Data: " + x);
        if (!map.contains(x)) {
            if (dq.size() == cacheSize) {
                int last = dq.removeLast();
                map.remove(last);
            }
        }
        else {
            /* Found entry may not be always last element, even if it's an intermediate element that needs to be removed & added to start of Queue */
            int index = 0, i = 0;
            Iterator<Integer> itr = dq.iterator();
            while (itr.hasNext()) {
                if (itr.next() == x) {
                    index = i;
                    break;
                }
                i++;
            }
            dq.remove(index);
        }
        dq.push(x);
        map.add(x);
    }

    private static void display()
    {
        System.out.print("INFO: Contents in LRU Cache: ");
        Iterator<Integer> itr = dq.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        System.out.println("INFO: Created cache with Size: " + cacheSize);
        set(1);
        set(2);
        set(3);
        set(1);
        set(4);
        set(5);
        display();
    }
}




/*

Output:
—————————————————————— 

INFO: Created cache with Size: 4

SET:  Storing Data: 1

SET:  Storing Data: 2

SET:  Storing Data: 3

SET:  Storing Data: 1

SET:  Storing Data: 4

SET:  Storing Data: 5
INFO: Contents in LRU Cache: 5 4 1 3 



*/


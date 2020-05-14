import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Implement a data structure to accomplish
 *          a) record the last N order ids in a log
 *          b) gets the ith last element from the log
 * Approach: Use Array List for random access
 *
 * Time Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class LastN {

    private static List<Integer> array = new ArrayList<>();

    public static void main(String[] args) {
        record(13);   // 1
        record(76);   // 2
        record(32);   // 3
        record(100);  // 4
        System.out.println(getLast(3));
    }

    static void record(int orderId) {
        array.add(orderId);
    }

    static int getLast(int i) {
        return array.get(array.size()-i);
    }
}


/*
Output:
—————————————————————— 

76



*/

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: Compute the running median of a sequence of numbers.
 * Approach: Use Min heap and Max heap.
 *
 * Time Complexity: O(log n).
 *    At worst, there are 3 heap insertions and 2 heap deletions from the top. Each of these takes about O(log n) time.
 *    Finding the mean takes constant O(1) time since the tops of heaps are directly accessible.
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
class MedianFinder {

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size()<maxHeap.size()) { // Always look after that size of minHeap >= maxHeap
            minHeap.offer(maxHeap.poll());
        }
    }

    public static double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();   // Root of minHeap is median
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0; // Average of 2 roots, when size is same. 
        }
    }

    public static void main(String[] args) {
        addNum(2);
        System.out.println("Median so far: " + findMedian());
        addNum(1);
        System.out.println("Median so far: " + findMedian());
        addNum(5);
        System.out.println("Median so far: " + findMedian());
        addNum(7);
        System.out.println("Median so far: " + findMedian());
        addNum(2);
        System.out.println("Median so far: " + findMedian());
        addNum(0);
        System.out.println("Median so far: " + findMedian());
        addNum(5);
        System.out.println("Median so far: " + findMedian());
    }

}


/*
Output:
—————————————————————— 

Median so far: 2.0
Median so far: 1.5
Median so far: 2.0
Median so far: 3.5
Median so far: 2.0
Median so far: 2.0
Median so far: 2.0

*/

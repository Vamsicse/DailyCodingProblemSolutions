import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: Given list of points on a plane, Find the K closest points to the origin (0, 0)
 * Approach: Use a Priority Queue sorted based on distance.
 *           Compare this question with K frequent elements.
 *
 * Time Complexity: O(NlogK)
 * Space Complexity: O(N)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        int[][] points1 = {{1, 1}, {-1, -1}, {3, 4}, {6, 1}, {-1, -6}, {-4, -3}};
        int k=2;
        System.out.println(Arrays.deepToString(obj.kClosest(points1, k)));
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println(Arrays.deepToString(obj.kClosest(points2, k)));
    }

    // Runtime: 22ms, Memory: 48.2MB
    public int[][] kClosest(int[][] points, int K) {
        int[][] kth = new int[K][2];
        // PriorityQueue<int[]> que = new PriorityQueue<>((p1, p2)->(p1[0]*p1[0] + p1[1]*p1[1] - (p2[0]*p2[0] + p2[1]*p2[1])));
        // or
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));
        for(int[] point: points){
            que.offer(point);
        }
        for(int i = 0; i < K; i++){
            kth[i] = que.poll();
        }
        return kth;
    }

}


/*
Output:
—————————————————————— 

[[1, 1], [-1, -1]]
[[3, 3], [-2, 4]]


*/

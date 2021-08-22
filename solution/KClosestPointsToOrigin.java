import java.util.*;

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
        int[][] points1 = { {1, 1}, {-1, -1}, {3, 4}, {6, 1}, {-1, -6}, {-4, -3} };
        int k=2;
        System.out.println(Arrays.deepToString(obj.kClosest(points1, k)));
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println(Arrays.deepToString(obj.kClosest(points2, k)));

        List<Point> listPoints1 = new ArrayList<>();
        listPoints1.add(new Point(1,1));listPoints1.add(new Point(-1,-1));listPoints1.add(new Point(3,4));
        listPoints1.add(new Point(6,1));listPoints1.add(new Point(-1,-6));listPoints1.add(new Point(-4,-3));
        System.out.println(kClosestToGivenPoint(listPoints1, new Point(0,0), k));

        List<Point> listPoints2 = new ArrayList<>();
        listPoints2.add(new Point(3,3)); listPoints2.add(new Point(5,-1)); listPoints2.add(new Point(-2,4));
        System.out.println(kClosestToGivenPoint(listPoints2, new Point(0,0),k));
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

    
    
    private static List<Point> kClosestToGivenPoint(List<Point> list, final Point center, int k) {
        List<Point> ans = new ArrayList<>();
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k + 1, (o1, o2) -> distance(center, o2) - distance(center, o1));
        for (Point p : list) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        Iterator<Point> i = maxHeap.iterator();
        while (i.hasNext()) {
            ans.add(i.next());
        }
        return ans;
    }

    private static int distance(Point p1, Point p2) {
        return (p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y) * (p1.y-p2.y);
    }

    static class Point {
        int x,y;
        public Point(int x, int y) { this.x = x;this.y = y; }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            if (x != point.x) return false;
            return y == point.y;
        }
        @Override
        public int hashCode() { return 31*x+y; }
        @Override
        public String toString(){return "["+x+","+y+"]";}
    }

}


/*
Output:
—————————————————————— 

[[1, 1], [-1, -1]]
[[3, 3], [-2, 4]]


*/

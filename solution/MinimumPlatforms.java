import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: Find minimum number of platforms required a.k.a Find minimum meeting rooms required.
 * Approach: Sort and One-pass comparison
 *
 * Time complexity : O(nlogn).
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2019-12-27
 */
public class MinimumPlatforms {

    // Approach 2: Sort and Slide
    static int findPlatform(double arr[], double dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1, i=1, j=0;
        while (i < n && j < n) {
            if (arr[i] < dep[j]) {
                plat_needed++;
                i++;
                if (plat_needed > result)
                    result = plat_needed;
            }
            else {
                plat_needed--;
                j++;
            }
        }
        return result;
    }

    // Approach 2: Using Heap
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int[] itv : intervals) {
            if(heap.isEmpty()) {
                count++;
            } else {
                if (itv[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }
            }
            heap.offer(itv[1]);
        }
        return count;
    }

    public static void main(String[] args) {
        double arr1[] = {900,  940,  950, 1100, 1500, 1800};
        double dep1[] = {910, 1200, 1120, 1130, 1900, 2000};
        int[][] timings1 = { {900,910}, {940,1200}, {950,1120}, {1100,1130}, {1500,1900}, {1800,2000} };
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr1, dep1, arr1.length));
        System.out.println("Minimum Number of Platforms Required = " + minMeetingRooms(timings1));
        System.out.println();
        double arr2[] = {9.00,  9.40,  9.50, 11.00, 15.00, 18.00};
        double dep2[] = {9.10, 12.00, 11.20, 11.30, 19.00, 20.00};
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr2, dep2, arr2.length));
        System.out.println();
        double arr3[] = {30, 0, 60};
        double dep3[] = {75, 50, 150};
        int[][] timings3 = { {30,75}, {0,50}, {60, 150} };
        System.out.println("Minimum Number of Platforms Required = " + minMeetingRooms(timings3));
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr3, dep3, arr3.length));
        System.out.println();
        double arr4[] = {2, 36, 9, 16, 4};
        double dep4[] = {15, 45, 29, 23, 9};
        int[][] timings4 = { {2,15}, {36,45}, {9,29}, {16,23}, {4,9} };
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr4, dep4, arr4.length));
        System.out.println("Minimum Number of Platforms Required = " + minMeetingRooms(timings4));
    }
}


/*
Output:
——————————————————————

Minimum Number of Platforms Required = 3
Minimum Number of Platforms Required = 3

Minimum Number of Platforms Required = 3

Minimum Number of Platforms Required = 2
Minimum Number of Platforms Required = 2

Minimum Number of Platforms Required = 2
Minimum Number of Platforms Required = 2


*/

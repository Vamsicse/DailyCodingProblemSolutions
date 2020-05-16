/**
 * Problem: Find fixed point.
 * Approach: Use modified Binary Search
 *
 * Time Complexity: O(logn)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class FixedPoint
{
    static int binarySearch(int arr[]) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(arr[mid] == mid){
                return mid;
            } else if(arr[mid] > mid){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr1[] = {-10, -1, 0, 3 , 10, 11, 30, 50, 100};
        System.out.println("Fixed Point is " + binarySearch(arr1));
        int arr2[] = {-6, 0, 2, 40};
        System.out.println("Fixed Point is " + binarySearch(arr2));
        int arr3[] = {1, 5, 7, 8};
        System.out.println("Fixed Point is " + binarySearch(arr3));
    }
}




/*

Output:
—————————————————————— 

Fixed Point is 3
Fixed Point is 2
Fixed Point is -1



*/


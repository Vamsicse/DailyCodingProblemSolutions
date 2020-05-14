/**
 * Problem: Find element in Sorted and Rotated Array.
 * Approach: Use Binary Search.
 * 
 * Time Complexity: O(logn)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
        int[] arr = {13, 18, 25, 2, 8, 10};
        System.out.println(obj.search(arr, 8));
    }

    // Runtime:0ms, Memory:38.7MB
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return -1;
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            // rotation happened
            if (arr[low] > arr[high]) { // mid < target < high
                if (target == arr[high])
                    return high;
                else
                    high--;
            }
            // no rotation
            else {
                if (target < arr[low] || arr[high] < target)
                    return -1;
                if (arr[low] <= target && target < arr[mid])
                    high = mid - 1;
                if (arr[mid] < target && target <= arr[high])
                    low = mid + 1;
            }
        }
        if (arr[low] == target)
            return low;
        else
            return -1;
    }

}

/*
Output:
—————————————————————— 

4



*/

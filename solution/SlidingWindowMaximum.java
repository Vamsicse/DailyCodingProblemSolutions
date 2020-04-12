import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem: Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 * Approach 1 (1ms): Keep track of max window. max_index - the index of maximum in current (or previous if in next loop) sliding window.
 * Approach 2 (7ms): create a Deque, Qi of capacity k, that stores only useful elements of current window of k elements.
 *  An element is useful if it is in current window and is greater than all other elements on left side of it in current window.
 *  We process all array elements one by one and maintain Qi to contain useful elements of current window and these useful elements are maintained in sorted order.
 *  The element at front of the Qi is the largest and element at rear of Qi is the smallest of current window.
 *
 * Time Complexity: O(n)
 * Space Complexity: Approach(1): O(1), Approach2: O(k)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int arr1[] = { 10, 5, 2, 7, 8, 7 };
        int arr2[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        System.out.println("Max value of each subarray is " + Arrays.toString(maxSlidingWindow(arr1,k)));
        System.out.println("Max value of each subarray is " + Arrays.toString(maxSlidingWindow(arr2,k)));
    }

    // Approach 1 (1 ms)
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int size = arr.length;
        if( arr.length == 0 || k == 0 || k > arr.length) {
            return new int[0];
        }
        int[] max_window = new int[size-k+1];  // (size-k+1) is the size of result
        int max_index = -1;
        int index=0;
        for(int i=0 ; i<size-k+1 ; i++) {
            if(i>max_index) {
                max_index = i;
                for(int j=i; j<i+k; j++) {
                    if(arr[j]>= arr[max_index])
                        max_index=j;
                }
            }
            else {
                if(arr[i+k-1] > arr[max_index])
                    max_index=  i+k-1;
            }
            max_window[index++] = arr[max_index];
        }
        return max_window;
    }


    // Approach 2 (7 ms)
    public static int[] maximumSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(nums==null || n==0) {
            return new int[0];
        }
        int[] maxValue = new int[n-k+1];  // n-k+1 sub-arrays are possible
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(!deque.isEmpty() && deque.peekFirst()==i-k) {
                deque.poll();     // Removes first element
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            deque.offer(i); // Adds at tail
            if(i+1 >= k) {
                maxValue[i+1-k] = nums[deque.peek()];
            }
        }
        return maxValue;
    }

}


/*
Output:
—————————————————————— 

Max value of each subarray is [10, 7, 8, 8]
Max value of each subarray is [78, 90, 90, 90, 89]


*/






// More Info: https://aaronice.gitbooks.io/lintcode/data_structure/sliding_window_maximum.html
//            http://buttercola.blogspot.com/2015/09/leetcode-sliding-window-maximum.html
//            https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

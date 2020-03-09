/**
 * Find Maximum sum such that no two elements are adjacent
 *
 * Approach: Loop for all elements in arr[] and maintain two sums incl and excl where incl = Max sum including the previous element and excl = Max sum excluding the previous element.
 * Max sum excluding the current element will be max(incl, excl) and max sum including the current element will be excl + current element (Note that only excl is considered because elements cannot be adjacent).
 * At the end of the loop return max of incl and excl.
 *
 * Time Complexity: O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class MaxSumNonAdjacent {

    public static void main(String[] args) {
        int arr1[] = new int[]{5, 5, 10, 100, 10, 5};   //110
        System.out.println("Max Sum of Non Adjacent elements is: " + findMaxSumNonAdjacent(arr1));
        int arr2[] = new int[]{2, 4, 6, 8};  //12
        System.out.println("Max Sum of Non Adjacent elements is: " + findMaxSumNonAdjacent(arr2));
        int arr3[] = new int[]{5, 1, 1, 5};   //10
        System.out.println("Max Sum of Non Adjacent elements is: " + findMaxSumNonAdjacent(arr3));
    }

    private static int findMaxSumNonAdjacent(int[] arr){
        int incl = arr[0], size=arr.length;
        int excl = 0, excl_new;
        for (int i = 1; i < size; i++) {
            excl_new = (incl > excl) ? incl : excl;   /* current max excluding i */
            incl = excl + arr[i];  /* current max including i */
            excl = excl_new;
        }
        return ((incl > excl) ? incl : excl);  /* return max of incl and excl */
    }

}



/*
Output:
—————————————————————— 

Max Sum of Non Adjacent elements is: 110
Max Sum of Non Adjacent elements is: 12
Max Sum of Non Adjacent elements is: 10


*/


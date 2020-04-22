import java.util.Arrays;

/**
 * Problem: Find Smallest Positive number
 * Approach: Segregate positive numbers and find smallest positive number
 *
 * Time Complexity: ~ O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class SmallestPositiveNumber {

    // Runtime: 0 ms 
    public static int firstMissingPositive(int[] nums, int size) {
        for(int i=0 ;i < size; i++){
            if(nums[i] <= 0 || nums[i] > size){
                nums[i] = size+1;
            }
        }
        for(int i = 0; i < size; i++){
            int pos = nums[i] > 0 ? nums[i] : (-1 * nums[i] );
            if(pos <= size && nums[pos-1] > 0){
                nums[pos-1] *= -1;
            }
        }
        for(int i = 0 ; i < size; i++){
            if(nums[i] > 0 ){
                return i+1;
            }
        }
        return size+1;
    }


    public static void main(String[] args) {
        int arr1[] = {0, 10, 2, -10, -20};
        System.out.println("Missing smallest positive number among " + Arrays.toString(arr1) + " is: ");
        System.out.println(firstMissingPositive(arr1, arr1.length));
        int arr2[] = {3, 4, -1, 1};
        System.out.println("Missing smallest positive number among " + Arrays.toString(arr2) + " is: ");
        System.out.println(firstMissingPositive(arr2, arr2.length));
        int arr3[] = {1, 2, 0};
        System.out.println("Missing smallest positive number among " + Arrays.toString(arr3) + " is: ");
        System.out.println(firstMissingPositive(arr3, arr3.length));
        int arr4[] = {-1, -2, -3, 10};
        System.out.println("Missing smallest positive number among " + Arrays.toString(arr4) + " is: ");
        System.out.println(firstMissingPositive(arr4, arr4.length));
    }

}



/*
  Output:
  -------
  Missing smallest positive number among [0, 10, 2, -10, -20] is: 1
  Missing smallest positive number among [3, 4, -1, 1] is: 2
  Missing smallest positive number among [1, 2, 0] is: 3
  Missing smallest positive number among [1, 2, 3, 10] is: 4
*/

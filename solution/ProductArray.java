import java.util.Arrays;

/**
 * Product Array
 *
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size)
 * such that prod[i] is equal to the product of all the elements of arr[] except arr[i].
 * Solve it without division operator and in O(n).
 * arr[] = {10, 3, 5, 6, 2}      prod[] = {180, 600, 360, 300, 900}
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
class ProductArray {

    // Runtime: 1ms, Memory: 48.1MB
    public int[] productExceptSelf(int[] nums) {
        int curr = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            res[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            res[i] *= curr;
            curr *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductArray pa = new ProductArray();
        int arr[] = { 10, 3, 5, 6, 2 };
        System.out.println("Given Array is " + Arrays.toString(arr));
        System.out.println("The product array is : " + Arrays.toString(pa.productExceptSelf(arr)));
    }
} 




/*
Output:
—————————

The product array is : 
180 600 360 300 900 

*/

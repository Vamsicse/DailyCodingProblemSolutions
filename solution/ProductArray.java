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
    void productArray(int arr[], int n)
    {
        if (n == 1) {
            System.out.print("0");
            return;
        }
        int i, temp = 1;
        int prod[] = new int[n];
        for (int j = 0; j < n; j++)
            prod[j] = 1; 
  
        /* In this loop, temp variable contains product of 
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }

        /* Initialize temp to 1 for product on right side */
        temp = 1; 
  
        /* In this loop, temp variable contains product of 
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }

        for (i = 0; i < n; i++)
            System.out.print(prod[i] + " ");

        return;
    }

    public static void main(String[] args) {
        ProductArray pa = new ProductArray();
        int arr[] = { 10, 3, 5, 6, 2 };
        int n = arr.length;
        System.out.println("The product array is : ");
        pa.productArray(arr, n);
    }
} 
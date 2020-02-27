import java.util.Arrays;

/**
 * Problem: Find Pythagorean Triplets in given sequence
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class PythagoreanTriplets {

    static void isTriplet(int arr[])
    {
        int n = arr.length;
        boolean found = false;
        for (int i = 0; i < n; i++)
            arr[i] *= arr[i];

        Arrays.sort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));

        for (int i = 0; i<n-2; i++) {
            int j = i+1; // index of the first element in arr[0..i-1]
            int k = n-1; // index of the last element in arr[0..i-1]
            while (j < k) {
                if (arr[i] + arr[j] == arr[k]){
                    found=true;
                    System.out.println("Found: " + (int)Math.sqrt(arr[i]) + "," + (int)Math.sqrt(arr[j]) + "," + (int)Math.sqrt(arr[k]));
                }
                if (arr[i] + arr[j] < arr[k])
                    k--;
                else
                    j++;
            }
        }
        if(!found){
            System.out.println("No Triplets found...");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 4, 7, 6};
        isTriplet(arr);
    }

}

import java.util.Arrays;

/**
 * Problem: Find minimum number of platforms required.
 * Approach: Sort and One-pass comparison
 *
 * Time complexity : O(nlogn) + O(n).
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class MinimumPlatforms {
    static int findPlatform(double arr[], double dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1, i=1, j=0;
        while (i < n && j < n)
        {
            if (arr[i] <= dep[j])
            {
                plat_needed++;
                i++;
                if (plat_needed > result)
                    result = plat_needed;
            }
            else
            {
                plat_needed--;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        double arr1[] = {900, 940, 950, 1100, 1500, 1800};
        double dep1[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr1, dep1, arr1.length));
        double arr2[] = {9.00, 9.40, 9.50, 11.00, 15.00, 18.00};
        double dep2[] = {9.10, 12.00, 11.20, 11.30, 19.00, 20.00};
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr2, dep2, arr2.length));
    }
}


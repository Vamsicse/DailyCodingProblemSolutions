import java.util.Arrays;

/**
 * Problem: Count number of Inversions
 * Approach: Use Enhanced Merge Sort.
 *           Count inversions during the merge step. Track # of inversions in left subarray, right subarray and merge().
 *
 * Time Complexity: O(n logn)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class CountInversions {

    static long countInversions(int[] arr) {
        long inversionsCount;
        int [] lowerArray = new int [arr.length];
        int [] higherArray = new int [arr.length]; //frm mid+1 to high
        inversionsCount = countAndSort (arr, 0, arr.length - 1, lowerArray, higherArray);
        return inversionsCount;
    }

    static long countAndSort(int [] arr, int low, int high, int [] lowerArray, int [] higherArray) {
        long totalCount = 0;
        if (low < high) {
            int mid = low + (high-low) /2;
            long lowerCount = countAndSort (arr, low, mid, lowerArray, higherArray);
            long higherCount = countAndSort (arr, mid+1, high, lowerArray, higherArray);
            totalCount += lowerCount + higherCount + countAndSortMerge (arr, low, mid, high, lowerArray, higherArray);
        }
        return totalCount;
    }

    static long countAndSortMerge(int [] arr, int low, int mid, int high, int [] lowerArray, int [] higherArray) {
        long countInversions = 0;
        for (int i=0; i< (mid-low+1);i++) {
            lowerArray[i] = arr [low+i];
        }
        for (int i=0; i< (high-mid);i++) {
            higherArray[i] = arr [mid+1+i];
        }
        int lowIndex = 0, highIndex = 0;
        int arrIndex = low;

        while (lowIndex < (mid-low+1) && highIndex < (high-mid)) {
            if (lowerArray[lowIndex] <= higherArray [highIndex]) {
                arr[arrIndex] = lowerArray[lowIndex];
                ++lowIndex;
            }
            else {
                arr[arrIndex] = higherArray[highIndex];
                ++highIndex;
                countInversions += (mid-low+1 - lowIndex);
            }
            ++arrIndex;
        }
        while (lowIndex < (mid-low+1)) {
            arr[arrIndex] = lowerArray[lowIndex];
            ++lowIndex;
            ++arrIndex;
        }
        while (highIndex < (high-mid)) {
            arr[arrIndex] = higherArray[highIndex];
            ++highIndex;
            ++arrIndex;
        }
        return countInversions;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 20, 6, 4, 5 };
        int[] arr2 = { 2, 4, 1, 3, 5 };
        System.out.println(Arrays.toString(arr1)+  "\nInversions: " + countInversions(arr1));
        System.out.println(Arrays.toString(arr2)+  "\nInversions: " + countInversions(arr2));
    }

}


/*
Output:
——————————————————————

[1, 20, 6, 4, 5]
Inversions: 5

[2, 4, 1, 3, 5]
Inversions: 3


*/

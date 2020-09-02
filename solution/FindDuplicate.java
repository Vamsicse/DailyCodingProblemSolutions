import static java.lang.Math.abs;

/**
 * Problem: Find duplicate element based on pigeon hole principle.
 * Approach: The elements in the array is from 0 to n-1 and all of them are positive.
 *           There is a catch, the array is of length n and the elements are from 0 to n-1 (n elements).
 *           The array can be used as a HashMap.
 * Algorithm: Traverse the array. For every element,take its abs value & if abs(array[i])‘th element is positive,
 *            the element has not encountered before, else if negative element has been encountered before, print abs value of current element.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,3};
        printRepeating(arr1);
    }

    // TC: O(n), SC:O(1), Runtime: 1ms, Memory: 39.6MB
    public static void printRepeating(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[abs(arr[i])] >= 0)
                arr[abs(arr[i])] = -arr[abs(arr[i])];
            else
                System.out.print(abs(arr[i]) + " ");
        }
    }

}

/*
Output:
——————————————————————
3

*/

//LeetCode: https://leetcode.com/problems/find-the-duplicate-number

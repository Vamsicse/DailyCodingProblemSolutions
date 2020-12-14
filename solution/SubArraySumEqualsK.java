import java.util.HashMap;

/**
 * Problem: Subarray Sum Equals K. Given an array of integers nums and an integer k,
 *          return the total number of continuous sub arrays whose sum equals to k.
 * HashMap Approach: If the cumulative sum(represented by sum[i] for sum upto ith index) upto two indices is the same,
 *           the sum of the elements lying in between those indices is zero.
 *           Extending the same thought further, if the cumulative sum upto two indices, say i and j is at a difference of k
 *           i.e. if sum[i]-sum[j]=k, the sum of elements lying between indices i and jj is k.
 *           Based on these thoughts, we make use of a hashmap map which is used to store the cumulative sum upto all
 *           the indices possible along with the number of times the same sum occurs.
 *           We store the data in the form: (sum_i, #occurences of sum_i).
 *           We traverse over the array nums and keep on finding the cumulative sum.
 *           Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum.
 *           If the same sum occurs again, we increment the count corresponding to that sum in the hashmap.
 *           Further, for every sum encountered, we also determine the number of times the sum (sum−k) has occurred already,
 *           since it will determine the number of times a subarray with sum k has occurred upto the current index.
 *           We increment the count by the same amount.
 *           After the complete array has been traversed, the count gives the required result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class SubArraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
        System.out.println(subarraySum(new int[]{1,2,3}, 9));
        System.out.println(subarraySum(new int[]{12,1,61,5,9,2}, 24));
    }

    // Runtime: 17ms, Memory: 41.5MB [HashMap Approach], TC: O(n), SC: O(n)
    public static int subarraySum(int[] arr, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}

/*
Output:
—————————
2
2
0

*/




// To print subsets for a given sum visit the following page
// https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/


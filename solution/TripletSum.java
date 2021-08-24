import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Triplet Sum.
 * Approach: Sort and Solve
 *
 * Time complexity : O(n^2)
 * Space Complexity: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2020-12-27
 */
public class TripletSum {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        printAllTriplets(arr,0);
        System.out.println(threeSum(arr));
    }

    // TC: O(n^2)
    private static void printAllTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i <= arr.length - 3; i++) {
            int k = target - arr[i];  // remaining sum
            int low = i + 1;
            int high = arr.length - 1;
            while (low < high) {
                if (arr[low] + arr[high] < k) {
                    low++;
                }
                else if (arr[low] + arr[high] > k) {
                    high--;
                }
                else {
                    System.out.println("(" + arr[i] + ", " + arr[low] + ", " + arr[high] + ")");
                    low++;
                    high--;
                }
            }
        }
    }

    // Runtime: 18ms, Memory:42.2MB, TC: O(n^2)
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i]==nums[i-1])continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]>0)k--;
                else if(nums[i]+nums[j]+nums[k]<0)j++;
                else{
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    while(j<k&&nums[j]==nums[j-1])j++;
                    while(k>j&&nums[k]==nums[k+1])k--;
                }
            }
        }
        return res;
    }

}

/*
Output:
-----------
(-1, -1, 2)
(-1, 0, 1)
(-1, 0, 1)
[[-1, -1, 2], [-1, 0, 1]]

 */

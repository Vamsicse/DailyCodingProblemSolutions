/**
 * Problem: Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *          LeetCode: #35
 * Approach: Use Binary Search
 *
 * Time Complexity: O(logn)
 * Auxiliary Space: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2020-12-27
 */
public class SearchInsertPosition {

    // Runtime: 0ms, Memory: 38.4MB
    public static int searchInsert(int[] nums, int target) {
        if(target< nums[0])
            return 0;
        if(target>nums[nums.length-1])
            return nums.length;
        int l=0, mid, h=nums.length-1;
        while(l<nums.length && h<nums.length && l<=h) {
            mid = l+(h-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(target<nums[mid])
                h=mid-1;
            else if(target>nums[mid])
                l=mid+1;
        }
        if(nums[l]>target)
            return l;
        else
            return l+1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }

}

/*
Output:
——————————————————————

2
1
4
0

*/
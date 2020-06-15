import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem: Given unsorted integer array, find length of longest consecutive elements sequence.
 * Approach: 1.HashSet and Intelligent Sequence Building:
               Numbers are stored in a HashSet to allow O(1) lookups, and we only attempt to build sequences from numbers that are not already part of a longer sequence.
               This is accomplished by first ensuring that number that would immediately precede the current number in a sequence is not present, as that number would necessarily be part of a longer sequence.
             2.Sort and Iterate
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    // TC:O(n), SC:O(n), Runtime: 3ms, Memory: 39.7MB
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num, currentStreak = 1;
                while (num_set.contains(currentNum+1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = (longestStreak>currentStreak)?longestStreak:currentStreak;
            }
        }
        return longestStreak;
    }

    // TC:O(nlogn), SC:O(1), Runtime: 2ms, Memory: 39.9MB
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int currentStreak = 1, longestStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak++;
                }
                else {
                    longestStreak = longestStreak>currentStreak?longestStreak:currentStreak;
                    currentStreak = 1;
                }
            }
        }
        return longestStreak>currentStreak?longestStreak:currentStreak;
    }

}


/*
Output:
———————————————— 
4

*/

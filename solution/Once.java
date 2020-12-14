import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find elements that appear once
 * Approach1 : One-pass HashSet
 * Approach2 : Bitwise operations
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class Once {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10, 2, 6, 10, 10);
        new Once().findSingles(list);
        int[] arr = {6, 1, 3, 3, 3, 6, 6, 8, 8};
        System.out.println(getSingle(arr, arr.length));
    }

    // TC: O(n), SC: O(n), Runtime: 4 ms, Memory: 39.7 MB
    private Set<Integer> findSingles(List<Integer> list){
        int size = list.size();
        Set<Integer> once = new HashSet<>();
        Set<Integer> multi = new HashSet<>();
        for(int i=0;i<size;i++){
            int current = list.get(i);
            if(!once.contains(current) && !multi.contains(current)){
                once.add(current);
            }
            else if(once.contains(current)){
                once.remove(current);
                multi.add(current);
            }
        }
        System.out.println("Once: " + once + "\t" + "Multi: " + multi);
        return once;
    }

    // TC: O(n), SC: O(1), Runtime: 0 ms, Memory: 38.9 MB
    private static int getSingle(int arr[], int n) {
        int ones = 0, twos = 0;
        int common_bit_mask;

        for (int i = 0; i < n; i++) {
            /*"one & arr[i]" gives the bits that are there in both 'ones' and new element from arr[]. We add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & arr[i]);
            /*"one & arr[i]" gives the bits that are there in both 'ones' and new element from arr[]. We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ arr[i];
            /* The common bits are those bits which appear third time So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos);
            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask;
            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask;
        }
        return ones;
    }

}



/*
Output:
—————————

Once: [4, 8]	Multi: [2, 6, 10]
1

*/

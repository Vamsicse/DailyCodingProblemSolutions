import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find elements that appear once
 * Approach: One-pass HashSet
 *
 * Time complexity : O(n). We traverse the list containing n elements only once. Each look up in table costs O(1) time.
 * Space complexity : O(n). Extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class Once {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10, 2, 6, 10, 10);
        new Once().findSingles(list);
    }

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
        System.out.println("Once: " + once);
        System.out.println("Multi: " + multi);
        return once;
    }

}

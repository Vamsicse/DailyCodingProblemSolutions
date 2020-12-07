import java.util.Arrays;
import java.util.List;

/**
 * Problem: Given an array representing heights of neighboring buildings on a city street, from east to west.
 *          The city assessor would like us to write an algorithm that returns how many of these buildings have a view of the setting sun, in order to properly value street.
 *          For example, given array [3, 7, 8, 3, 6, 1], we should return 3, since the top floors of the buildings with heights 8, 6, and 1 all have an unobstructed view to the west.
 * Approach: Slide from last to first and track the number of buildings.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class BuildingsFacingSun {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 7, 8, 3, 6, 1);
        if(countBuildingsFacingSun(list)!=3){
            throw new RuntimeException("Failed");
        }
    }

    private static int countBuildingsFacingSun(final List<Integer> list){
        int buildings = 0, currMax = Integer.MIN_VALUE;
        for(int i=list.size()-1 ; i>-1 ; i--){
            if(list.get(i) > currMax){
                buildings++;
                currMax = list.get(i);
            }
        }
        return buildings;
    }

}

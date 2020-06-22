/**
 * Problem: There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 *    The cost of painting each house with a certain color is different.
 *    We have to paint all houses such that no 2 adjacent houses have the same color.
 *    The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 *    For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
 *    Find the minimum cost to paint all houses.
 * Approach: DP
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class PaintHouse {

    public static int minCost(int[][] costs) {
        if(costs==null||costs.length==0)
            return 0;

        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        int m = costs.length-1;
        return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
    }

    // Approach2: Without changing original array values
    /*
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        int[][] matrix = new int[3][costs.length];
        for(int j=0; j<costs.length; j++){
            if(j==0){
                matrix[0][j]=costs[j][0];
                matrix[1][j]=costs[j][1];
                matrix[2][j]=costs[j][2];
            }else{
                matrix[0][j]=Math.min(matrix[1][j-1], matrix[2][j-1])+costs[j][0];
                matrix[1][j]=Math.min(matrix[0][j-1], matrix[2][j-1])+costs[j][1];
                matrix[2][j]=Math.min(matrix[0][j-1], matrix[1][j-1])+costs[j][2];
            }
        }
        int result = Math.min(matrix[0][costs.length-1], matrix[1][costs.length-1]);
        result = Math.min(result, matrix[2][costs.length-1]);
        return result;
    } */

    public static void main(String[] args) {
        int[][] costs = { {17,2,17}, {16,6,5},{14,3,19}};
        // Paint 0 into blue, 1 into green, 2 into blue = 2+5+3
        assert minCost(costs)==10;
    }

}

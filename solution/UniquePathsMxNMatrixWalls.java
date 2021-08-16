/**
 * Problem: A robot is located at the top-left corner of a m x n grid (marked 'Start' in diagram below).
 *  The robot can only move either down or right at any point in time.
 *  The robot is trying to reach bottom-right corner of grid (marked 'Finish' in the diagram below).
 *  How many possible unique paths are there when obstacles are present?
 *
 * Approach: Use recurrence function
 *           No. of ways to reach cell[i][j] = cell[i-1][j] + cell[i][j-1]
 *
 * Time Complexity: O(mn)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class UniquePathsMxNMatrixWalls {

    public static void main(String[] args) {
        int[][] matrix1 = { {0, 0, 1},
                {0, 0, 1},
                {1, 0, 0}};
        System.out.println(new UniquePathsMxNMatrixWalls().uniquePathsWithObstacles(matrix1));
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        // If start cell has obstacle, then return as there would be no paths to destination.
        if (grid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        grid[0][0] = 1;

        // Filling values for first column
        for (int i = 1; i < R; i++) {
            grid[i][0] = (grid[i][0] == 0 && grid[i-1][0]==1) ? 1:0;
        }

        // Filling values for first row
        for (int i = 1; i < C; i++) {
            grid[0][i] = (grid[0][i] == 0 && grid[0][i-1]==1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways to reach cell[i][j] = cell[i-1][j] + cell[i][j-1] i.e. From above & left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        // Return value stored in rightmost bottommost cell. That is the destination.
        return grid[R - 1][C - 1];
    }

}

/*
Output:
——————————————————————
2


*/

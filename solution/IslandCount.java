/**
 * Problem: Find number of islands in 2D array, 1-Island, 0-Water
 * Approach: Use DFS
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class IslandCount {

    public static void main(String... z){
        char[][] grid1 = {  {'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '0'}};
        System.out.println("Islands: " + new IslandCount().numIslands(grid1));

        char[][] grid2 = {{'1', '1', '0', '0', '0'},
                          {'1', '1', '0', '0', '0'},
                          {'0', '0', '1', '0', '0'},
                          {'0', '0', '0', '1', '1'}};
        System.out.println("Islands: " + new IslandCount().numIslands(grid2));

        char[][] grid3 = {{'1', '0', '0', '0', '0'},
                          {'0', '0', '1', '1', '0'},
                          {'0', '1', '1', '0', '0'},
                          {'0', '0', '0', '0', '0'},
                          {'1', '1', '0', '0', '1'},
                          {'1', '1', '0', '0', '1'}};
        System.out.println("Islands: " + new IslandCount().numIslands(grid3));
    }

    // Runtime: 1ms, Memory: 41MB
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    public static void dfs(char[][] m, int i, int j) {
        if (!(i >= 0 && i < m.length && j >= 0 && j < m[0].length && m[i][j] == '1'))
            return;
        m[i][j] = '0';
        dfs(m, i-1, j);
        dfs(m, i+1, j);
        dfs(m, i, j-1);
        dfs(m, i, j+1);
    }

}


/*
Output:
——————————————————————
Islands: 1
Islands: 3
Islands: 4

*/
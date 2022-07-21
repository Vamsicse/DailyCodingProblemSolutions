import java.util.Arrays;

/**
 * Problem: LC:37. Sudoku Solver
 * Approach: Use Backtrack
 *          Try 1 through 9 for each cell.
 *          The time complexity should be 9 ^ m (m represents the number of blanks to be filled in), since each blank can have 9 choices.
 *
 * Time Complexity: O(9^m)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2020-12-27
 */
public class SudokuSolver {

    public static void main(String... z){
        SudokuSolver obj = new SudokuSolver();
        char[][] board1 = {{'5','3','.','.','7','.','.','.','.'}
                          ,{'6','.','.','1','9','5','.','.','.'}
                          ,{'.','9','8','.','.','.','.','6','.'}
                          ,{'8','.','.','.','6','.','.','.','3'}
                          ,{'4','.','.','8','.','3','.','.','1'}
                          ,{'7','.','.','.','2','.','.','.','6'}
                          ,{'.','6','.','.','.','.','2','8','.'}
                          ,{'.','.','.','4','1','9','.','.','5'}
                          ,{'.','.','.','.','8','.','.','7','9'} };
        obj.solveSudoku(board1);
        for(char[] rows : board1){
            System.out.println(Arrays.toString(rows));
        }
        System.out.println("****************************************");
        char[][] board2 = {{'8','3','.',  '.','7','.',   '.','.','.'}
                          ,{'6','.','.',  '1','9','5',   '.','.','.'}
                          ,{'.','9','8',  '.','.','.',   '.','6','.'}
                          ,{'8','.','.',  '.','6','.',   '.','.','3'}
                          ,{'4','.','.',  '8','.','3',   '.','.','1'}
                          ,{'7','.','.',  '.','2','.',   '.','.','6'}
                          ,{'.','6','.',  '.','.','.',   '2','8','.'}
                          ,{'.','.','.',  '4','1','9',   '.','.','5'}
                          ,{'.','.','.',  '.','8','.',   '.','7','9'}};
        obj.solveSudoku(board2);
        for(char[] rows : board2){
            System.out.println(Arrays.toString(rows));
        }
    }

    // Runtime: 15ms, Memory: 39MB
    public void solveSudoku(char[][] board) {
        doSolve(board, 0, 0);
    }

    private boolean doSolve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) { //trial. Try 1 through 9
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolve(board, i, j + 1))
                            return true;   // If it's solution return true
                        board[i][j] = '.';  // Otherwise go back
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || board[row][i] == num ||
                    board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        return true;
    }



}


// Explanation: https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking

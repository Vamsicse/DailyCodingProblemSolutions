/**
 * Problem: LC:36. Validate Sudoku
 * Approach: Use Bitwise arithmetic
 *
 *      Short has 2 bytes - 16 bits. we use each bit to represent if a number was seem on a row/col/box.
 *      for example, if we see 8 (board[0][0]) on First row (0th index),
 *      at line 11, value will be 1 << board[0][0] - '1' --> 1 << '8' - '1' --> 1<<7
 *         which means shift 1 by 7 spots, i.e., 1 is (in 8 bits) 10000000
 *         shifting 1 by 7 bits gives us 10000000. this represents 8 was seen which is set at line 17.
 *      at line 17 row[0] is 00000000. we use value calculated based on board[0][0] and set it to row[0] by row[0] = row[0] | value, i.e.,
 *           0 0 0 0 0 0 0 0
 *       OR  1 0 0 0 0 0 0 0
 *      ---------------------
 *           1 0 0 0 0 0 0 0
 *
 *      then, when we see 3 at board[0][1] --> value becomes 0 0 0 0 0 1 0 0 (shift 1 by 2)
 *      row[0] is 1 0 0 0 0 0 0 0. now at line 17 in this iteration, it becomes,
 *           1 0 0 0 0 0 0 0
 *       OR  0 0 0 0 0 1 0 0
 *      --------------------
 *           1 0 0 0 0 1 0 0
 *
 *      so, if at line 13, we saw another 8 or 3, the AND operation will give a value > 0,
 *         which would mean we saw it already.
 *         same is done for columns and boxes
 *
 *      Remember the formula to figure out the box index. --> 3 * (row/3) + col/3
 *         this gives the box index.
 *         for row = 0, col = 0, box should be 0
 *         3 * (0/3) + 0/3 = 0
 *
 *        for row = 3, col = 6,
 *        3 * (3/3) + 6/3 = 3 * (1) + 2 = 5 --> box index is 5
 *
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2020-12-27
 */
public class SudokuValidator {

    public static void main(String... z){
        char[][] board1 = {{'5','3','.','.','7','.','.','.','.'}
                          ,{'6','.','.','1','9','5','.','.','.'}
                          ,{'.','9','8','.','.','.','.','6','.'}
                          ,{'8','.','.','.','6','.','.','.','3'}
                          ,{'4','.','.','8','.','3','.','.','1'}
                          ,{'7','.','.','.','2','.','.','.','6'}
                          ,{'.','6','.','.','.','.','2','8','.'}
                          ,{'.','.','.','4','1','9','.','.','5'}
                          ,{'.','.','.','.','8','.','.','7','9'} };

        System.out.println(isValidSudoku(board1));

        char[][] board2 = {{'8','3','.',  '.','7','.',   '.','.','.'}
                          ,{'6','.','.',  '1','9','5',   '.','.','.'}
                          ,{'.','9','8',  '.','.','.',   '.','6','.'}
                          ,{'8','.','.',  '.','6','.',   '.','.','3'}
                          ,{'4','.','.',  '8','.','3',   '.','.','1'}
                          ,{'7','.','.',  '.','2','.',   '.','.','6'}
                          ,{'.','6','.',  '.','.','.',   '2','8','.'}
                          ,{'.','.','.',  '4','1','9',   '.','.','5'}
                          ,{'.','.','.',  '.','8','.',   '.','7','9'}};
        System.out.println(isValidSudoku(board2));
    }


    public static boolean isValidSudoku(char[][] board) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] squares = new short[9];

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') continue;

                short value = (short) (1 << board[row][col] - '1');

                if((value & rows[row]) > 0) return false;
                if((value & cols[col]) > 0) return false;
                if((value & squares[3*(row/3) + col/3]) > 0) return false;

                rows[row] |= value;
                cols[col] |= value;
                squares[3*(row/3) + (col/3)] |= value;
            }
        }
        return true;
    }

}


// Explanation: https://www.youtube.com/watch?v=i2YKwM9oCcY
// https://leetcode.com/problems/valid-sudoku/discuss/624148/Java-solution-100-time-and-space-with-explanation

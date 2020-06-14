/**
 * Problem: Search word in 2D grid.
 * Approach: Use DFS
 *
 * Time Complexity: O(m*n*4^s)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
class WordSearch {

    // Runtime: 4-7ms, Memory: 42.1MB
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(dfs(board, i, j, 0, arr))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, char[] word) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '.' || word[index] != board[i][j]) return false;
        char c = board[i][j];
        if(index == word.length-1) return true;
        board[i][j] = '.';
        boolean result =      dfs(board, i-1, j, index+1, word)
                           || dfs(board, i+1, j, index+1, word)
                           || dfs(board, i, j-1, index+1, word)
                           || dfs(board, i, j+1, index+1, word);
        board[i][j] = c;
        return result;
    }

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        char[][] board = {  {'F', 'A', 'C', 'I'},
                            {'O', 'B', 'Q', 'P'},
                            {'A', 'N', 'O', 'B'},
                            {'M', 'A', 'S', 'S'}  };
        System.out.println(obj.exist(board, "FOAM"));
        System.out.println(obj.exist(board, "MASS"));
        System.out.println(obj.exist(board, "FOAM"));
        System.out.println(obj.exist(board, "OBOB"));
    }

}

/*
Output:
——————————————————— 
true
true
true
false

*/


// https://cs.stackexchange.com/questions/96626/whats-the-big-o-runtime-of-a-dfs-word-search-through-a-matrix

/**
 * Problem: M is N by N row,column sorted matrix. No two elements of M are equal.
 *          Given i1, j1, i2, and j2, find number of elements smaller than M[i1, j1] & larger than M[i2, j2].
 * Approach: Check ro wby row while keeping track of lowest and highest numbers in row.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class CountSmallerElementsInMatrix {

    public static void main(String[] args) {
        CountSmallerElementsInMatrix obj = new CountSmallerElementsInMatrix();
        int[][] matrix = {
                {  1,  3,  7,  10,  15,  20 },
                {  2,  6,  9,  14,  22,  25 },
                {  3,  8, 10,  15,  25,  30 },
                { 10, 11, 12,  23,  30,  35 },
                { 20, 25, 30,  35,  40,  45 } };
        System.out.println(obj.count(matrix, 1, 1, 3, 3));
    }

    public int count(int[][] matrix, int i1, int j1, int i2, int j2) {
        int res = 0;
        int low = matrix[i1][j1];
        int high = matrix[i2][j2];

        for (int[] row : matrix) {
            if (row[0] > high || row[row.length - 1] < low)
                res += row.length;
            else if (row[0] >= low && row[row.length - 1] <= high)
                continue;
            for (int i = 0; i < row.length && row[i] < low; i++)
                res++;
            for (int i = row.length - 1; i >= 0 && row[i] > high; i--)
                res++;
        }
        return res;
    }

}



/*
Output:
——————————————————————
14

*/

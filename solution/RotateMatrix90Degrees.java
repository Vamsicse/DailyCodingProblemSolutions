/**
 * Problem: Rotate the image/matrix by 90 degrees (clockwise).
 *
 * Approach: Reverse the matrix around the main diagonal and then reverse it from left to right.
 *           Transpose + Reverse = Rotated
 *
 * Time Complexity: O(M), M is number of cells in matrix.
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class RotateMatrix90Degrees {

    // Runtime: 0ms, Memory: 39MB
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

}

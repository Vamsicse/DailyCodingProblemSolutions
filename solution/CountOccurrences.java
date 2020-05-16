/**
 * Problem: Given integers N and X, return the number of times X appears in an NxN multiplication table.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class CountOccurrences {

    public static void main(String[] args) {
        System.out.println(countOccurrences(6,12));
    }

    public static int countOccurrences(int n, int x) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i > x) {
                break;
            }
            if (x % i == 0 && x / i <= n) {
                count++;
            }
        }
        return count;
    }

}


/*
Output:
—————————————————————— 

4



*/

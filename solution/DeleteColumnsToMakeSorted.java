/**
 * Problem: Find number of columns to delete to make it sorted
 * Approach:
 *
 * Time Complexity: O(A)
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class DeleteColumnsToMakeSorted {

    // Runtime: 7-8ms, Memory: 39.8MB
    public int minDeletionSize(String[] A) {
        if (A == null) return 0;
        int count = 0;
        int len = A[0].toCharArray().length;
        for (int i = 0; i < len; i++) {
            if(isNoSort(A, i)) count++;
        }
        return count;
    }

    public static boolean isNoSort(String[] A, int num) {
        char c = A[0].charAt(num);
        for (int i = 0; i < A.length;i++) {
            if (A[i].charAt(num) < c) return true;
            c = A[i].charAt(num);
        }
        return false;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted obj = new DeleteColumnsToMakeSorted();
        String[] X = {"cba","daf","ghi"};
        System.out.println(obj.minDeletionSize(X));
        String[] Y = {"zyx","wvu","tsr"};
        System.out.println(obj.minDeletionSize(Y));
        String[] Z = {"abcdef"};
        System.out.println(obj.minDeletionSize(Z));
    }

}

/*
Output:
——————————————————— 

1
3
0


*/

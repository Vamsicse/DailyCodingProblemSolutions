/**
 * Problem: Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2. LC: 581
 * Approach: Use absolute and other arithmetic
 *
 * Time complexity : O(1)
 * Space complexity : O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class MaxOfTwoNumbers {

    private static int min(int x, int y) {
        return (x + y - Math.abs(x-y) )/2;
    }

    private static int max(int x, int y) {
        return (x + y + Math.abs(x-y) )/2;
    }

    public static void main(String[] args) {
        int x = 76, y = 32;
        System.out.print("Minimum of "+x+" and "+y+" is: " + min(x,y));
        System.out.print("Maximum of "+x+" and "+y+" is: " + max(x,y));
    }

}

/*
Output:
——————————————————————
Minimum of 76 and 32 is 32
Maximum of 76 and 32 is 76

*/
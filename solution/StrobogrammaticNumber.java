import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Strobogrammatic Number
 *
 * A Strobogrammatic number is a number whose numeral is rotationally symmetric, so that it appears the same when rotated 180 degrees.
 * In other words, the numeral looks the same right-side up and upside down (e.g., 69, 96, 1001).
 *
 * Create a program that finds all Strobogrammatic numbers with N digits.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class StrobogrammaticNumber {

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("818"));
        System.out.println(isStrobogrammatic("819"));
    }

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }


    /*
     * It is still detected by double pointers. If the first and the last two numbers are equal, only if they are one of 0, 1, and 8,
     * if they are not equal If one is 6 and one is 9, or one is 9 and the other is 6, all other cases will return false, see the code as follows
     */
    public static boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (num.charAt(l) == num.charAt(r)) {
                if (num.charAt(l) != '1' && num.charAt(l) != '0' && num.charAt(l) != '8'){
                    return false;
                }
            } else {
                if ((num.charAt(l) != '6' || num.charAt(r) != '9') && (num.charAt(l) != '9' || num.charAt(r) != '6')) {
                    return false;
                }
            }
            ++l; --r;
        }
        return true;
    }


    /*
    * Since there are not many numbers that meet the meaning of the question, we can use HashMap to do it.
    * Store all the mappings that meet the meaning of question in hash table, and then double-pointer scan to see if the two numbers at the corresponding position exist in the hash table.
    * If the mapping does not exist, return false, and return true when the traversal is complete, see the code as follows:
    */
    public boolean isStrobogrammaticUsingMap(String num) {
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('0','0');
        dict.put('1','1');
        dict.put('8','8');
        dict.put('6','9');
        dict.put('9','6');
        int i=0;
        int j = num.length()-1;
        while(i<=j){
            char l = num.charAt(i), r = num.charAt(j);
            if(dict.containsKey(l) && dict.containsKey(r) && dict.get(l) == r){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

}

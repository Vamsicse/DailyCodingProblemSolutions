/**
 * Problem: Minimum Remove to Make Valid Parentheses.
 * Approach: Scan forward and reverse for unbalanced parenthesis and mark '*' in their place.
 *           Then form a new string without '*'s.
 *
 * Time Complexity: ~O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */
public class MinRemoveValidParenthesis {

    // Runtime: 4ms, Memory: 40.4 MB
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int open = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                open++;
            else if (arr[i] == ')') {
                if (open == 0)
                    arr[i] = '*';
                else
                    open--;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (open > 0 && arr[i] == '(') {
                arr[i] = '*';
                open--;
            }
        }
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*')
                arr[p++] = arr[i];
        }
        return new String(arr).substring(0, p);
    }

    public static void main(String[] args) {
        MinRemoveValidParenthesis minRemoveValidParenthesis = new MinRemoveValidParenthesis();
        String str1 = "()())()";
        System.out.println("Invalid: " + str1);
        String validString = minRemoveValidParenthesis.minRemoveToMakeValid(str1);
        System.out.println("Valid: " + validString);
        System.out.println("# of characters removed: " + (str1.length()-validString.length()));

        String str2 = ")(";
        System.out.println("Invalid: " + str2);
        validString = minRemoveValidParenthesis.minRemoveToMakeValid(str2);
        System.out.println("Valid: " + validString);
        System.out.println("# of characters removed: " + (str2.length()-validString.length()));
    }

}


/*
Output:
——————————————————————

Invalid: ()())()
Valid:   ()()()
# of characters removed: 1

Invalid: )(
Valid:
# of characters removed: 2


*/

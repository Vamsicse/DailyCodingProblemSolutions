import java.util.Stack;

/**
 * Problem: Balanced Parenthesis
 * Approach: Use Stack and One Pass
 *
 * Time complexity : O(n).
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class BalancedParenthesis {

    public static void main(String args[]) {
        System.out.println(balancedParenthesis("{(a,b)}"));
        System.out.println(balancedParenthesis("{(a},b)"));
        System.out.println(balancedParenthesis("{)(a,b}"));
        System.out.println(balancedParenthesis("{)(a,b}"));
        System.out.println(balancedParenthesis("{)(a,b}"));
    }

    public static boolean balancedParenthesis(String s) {
        Stack<Character> stack  = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}

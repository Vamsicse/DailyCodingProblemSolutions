/**
 * Problem: Check if string is palindrome
 * Approach: Check if each character is alpha numeric or not.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class Palindrome {

    // Runtime: 2ms, Memory: 39.4 MB
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        int i = 0, j = s.length()-1;
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!isAlphaNum(ch1)) {
                ++i;
            } else if (!isAlphaNum(ch2)) {
                --j;
            } else if (areEqual(ch1, ch2)) {
                ++i;
                --j;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return ( c >= 'a' && c <= 'z') || ( c >= 'A' && c <= 'Z') || isNum(c);
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean areEqual(char a, char b) {
        if (isNum(a) || isNum(b))
            return a == b;
        return a-'a' == b-'a' || a-'A' == b - 'A' || a-'a' == b - 'A'
                || a-'A' == b - 'a';
    }

    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        if(obj.isPalindrome("A man, a plan, a canal: Panama")!=true){
            throw new RuntimeException("Error");
        }
        if(obj.isPalindrome("race a car")!=false){
            throw new RuntimeException("Error");
        }
    }



}

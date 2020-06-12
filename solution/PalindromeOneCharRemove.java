/**
 * Problem: Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * Approach: Use Recursion
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class PalindromeOneCharRemove {

    // Runtime: 4ms, Memory: 40MB
    public boolean validPalindrome(String s) {
        if(s.length()==0) return true;
        int i=0;
        int j=s.length()-1;
        return check(s,i,j,false);
    }

    private boolean check(String s, int i, int j, boolean alreadyRemovedOne){
        while(i<j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        if(i>=j) return true;
        if(alreadyRemovedOne) return false; ////not palindromic and already removed one
        return check(s,i+1,j,true)||check(s,i,j-1,true); //try removing one from either end
    }

    public static void main(String[] args) {
        PalindromeOneCharRemove obj = new PalindromeOneCharRemove();
        if(obj.validPalindrome("aba")!=true) {
            throw new RuntimeException("Error");
        }
        if(obj.validPalindrome("abca")!=true) {
            throw new RuntimeException("Error");
        }
    }

}

import java.util.HashSet;

/**
 * Problem: Given a string, determine whether any permutation of it is a palindrome.
 * Approach: If a string can form a palindrome, it should contain characters with even number of occurences
 *           & one character with odd number of occurences, or only characters with even number of occurences.
 *           We can use a set to record the characters with odd number of occurences.
 *           Traverse the given string s, if we meet a character odd number of times, put it in the set, otherwise remove it.
 *           Return whether the number of characters in the set is 0 or 1.
 *
 * Time Complexity: O(n), n is length of string s, as we traverse each character in it.
 * Space Complexity: O(1), For worst case, set has all unique letters, total number of which is fixed.
 *
 * @author Vamsi Krishna Myalapalli
 * @version 1.0
 * @since 2019-12-27
 */

public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("carrace"));
        System.out.println(canPermutePalindrome("daily"));
        System.out.println(canPermutePalindrome("aab"));
    }

    public static boolean canPermutePalindrome(String s) {
        HashSet<Character> left = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(left.contains(s.charAt(i))){
                left.remove(s.charAt(i));
            }else {
                left.add(s.charAt(i));
            }
        }
        return left.size() < 2;
    }

}

// https://leetcode.com/problems/palindrome-permutation/

/*
Output:
——————————————————————

true
false
true


*/
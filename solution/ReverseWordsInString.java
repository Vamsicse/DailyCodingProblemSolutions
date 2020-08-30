/**
 * Problem: Reverse words in string
 * Approach: Split based on space character and form reverse worded string
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(n)
 * 
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("hello world here"));
    }

    // Runtime: 1ms, Memory: 39.5 MB
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.trim().split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].length() > 0) {
                sb.append(strings[i]);
                if (i > 0) sb.append(" ");
            }
        }
        return sb.toString();
    }

}

// https://leetcode.com/problems/reverse-words-in-a-string/

/*
Output:
——————————————————————
here world hello
*/

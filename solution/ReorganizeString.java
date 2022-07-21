/**
 * Problem: LC.767. Rearrange characters of given string so that no 2 adjacent characters are same.
 *      Return any possible rearrangement of s or return "" if not possible.
 * Approach:
 *      1. Count letter appearance and store in hash[i]
 *      2. Find the letter with largest occurence.
 *      3. Put the letter into even index numbe (0, 2, 4 ...) char array
 *      4. Put the rest into the array
 *
 *      Time O(N): fill hash[] + find the letter + write results into char array
 *      Space O(N + 26): result + hash[]
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("abba"));
        System.out.println(reorganizeString("aaabbc"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("aab"));
    }

    // Runtime: 0ms, Memory:37.3MB
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        } 
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return ""; 
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}

/*
Output:
——————————————————————
baba
ababac

aba

*/

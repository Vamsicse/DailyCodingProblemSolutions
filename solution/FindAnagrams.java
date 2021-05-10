import java.util.LinkedList;
import java.util.List;

/**
 * Problem: Given two strings s and p, return an array of all the start indices of p's anagrams in s. Answer can be in any order.
 * Approach: Iterative approach.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class FindAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abxaba", "ab"));
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    // Runtime: 3ms, Memory: 40MB
    public static List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> l=new LinkedList<>();
        int n=s.length(), m=p.length();
        if(n<m) {
            return l;
        }
        int a[]=new int[26];
        for(char c: p.toCharArray()) {
            a[c - 'a']++;
        }
        int b[]=new int[26];
        for(int i=0;i<m-1;i++) {
            b[s.charAt(i)-'a']++;
        }
        int j;
        for(int i=m-1;i<n;i++) {
            b[s.charAt(i)-'a']++;
            for(j=0;j<26;j++) {
                if (a[j] != b[j])
                    break;
            }
            if(j==26) {
                l.add(i - m + 1);
            }
            b[s.charAt(i-m+1)-'a']--;
        }
        return l;
    }

}

// https://leetcode.com/problems/find-all-anagrams-in-a-string


/*
Output:
——————————————————————

[0, 3, 4]
[0, 6]
[0, 1, 2]


*/

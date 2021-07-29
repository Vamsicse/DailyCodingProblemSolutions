/**
 * Problem: LC.767. Rearrange characters of given string so that no 2 adjacent characters are same.
 *      Return any possible rearrangement of s or return "" if not possible.
 * Approach:
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
    private static String reorganizeString(String S) {
        int index=-1; int max=0;
        int[] count=new int[26];
        for (char c:S.toCharArray()){
            count[c-'a']++;
            if (count[c-'a']>max){
                max=count[c-'a']; index=c-'a';
            }
        }
        if (max>S.length()-max+1) return "";
        char[] result=new char[S.length()];
        for (int k=0;k<result.length;k+=2){
            while (count[index]==0)
                index=(index+1)%count.length;
            result[k]=(char)('a'+index);
            count[index]--;
        }
        for (int k=1;k<result.length;k+=2){
            while (count[index]==0)
                index=(index+1)%count.length;
            result[k]=(char)(index+'a');
            count[index]--;
        }
        return new String(result);
    }
}

/*
Output:
——————————————————————
baba
ababac

aba

*/
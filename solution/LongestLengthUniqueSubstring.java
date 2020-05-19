import java.util.HashMap;

/**
 * Problem: FInd Longest length unique substring
 * Approach: Use HasMap to find duplicates.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class LongestLengthUniqueSubstring {

    public static void main(String[] args) {
        LongestLengthUniqueSubstring obj = new LongestLengthUniqueSubstring();
        System.out.println(obj.lengthOfLongestSubstring("eacebcda"));
    }

    // Runtime: 2ms, Memory: 39.8MB
    public int lengthOfLongestSubstring(String s) {
        int fre[]=new int[128];
        int start=0, maxLen=0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);  //char at i; check its occ in window;
            if(fre[ch-32]>0) {
                //it means we cannot include it, now we need to remove from start unless count becomes zero;
                while(fre[ch-32]>0) {
                    fre[s.charAt(start)-32]--;
                    start++;
                }
            }
            else {
                //increase size of window;
                if(i-start+1>maxLen) {
                    maxLen=i-start+1; //i-start+1 is length of curr of window;
                }
            }
            fre[ch-32]++;
        }
        return maxLen;
    }

    // Runtime: 5ms, Memory:39.7MB
    /*
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        int start=0, len=0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start)
                    start = map.get(c) + 1;
            }
            len = Math.max(len, i-start+1);
            map.put(c, i);
        }
        return len;
    }*/

}

/*
Output:
—————————————————————— 

5


*/

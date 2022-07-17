import java.util.HashMap;

/**
 * Problem: Find the longest substring with k unique characters in a given string
 * Approach: Use a Map and keep track of unique elements.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(s)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class LongestSubstringKUniqueChars {

    public static void main(String[] args) {
        LongestSubstringKUniqueChars obj = new LongestSubstringKUniqueChars();
        System.out.println(obj.lengthOfLongestSubstringKDistinct1("abcba", 2));
        System.out.println(obj.lengthOfLongestSubstringKDistinct1("aabbcc", 3));
    }

    // SC: O(s)
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        int l = 0, r = 0, cnt=0, res=0;
        int[] map = new int[256];
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            if (map[chars[r]] == 0) {
                cnt++;
            }
            map[chars[r]]++;
            if (cnt <= k) {
                res = Math.max(res, r - l + 1);
            }
            while (cnt > k) {
                if (--map[chars[l++]] == 0) {
                    cnt--;
                }
            }
            r++;
        }
        return res;
    }

    // SC:O(s)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;
        int i=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
            if(map.size()<=k){
                result = Math.max(result, j-i+1);
            }
            else{
                while(map.size()>k){
                    char l = s.charAt(i);
                    int count = map.get(l);
                    if(count==1){
                        map.remove(l);
                    }else{
                        map.put(l, map.get(l)-1);
                    }
                    i++;
                }
            }
        }
        return result;
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

3
6

*/

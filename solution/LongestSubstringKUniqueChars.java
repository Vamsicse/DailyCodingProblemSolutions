import java.util.HashMap;

/**
 * Problem: Find the longest substring with k unique characters in a given string
 * Approach: Use a Map and keep track of unique elements.
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class LongestSubstringKUniqueChars {

    public static void main(String[] args) {
        LongestSubstringKUniqueChars obj = new LongestSubstringKUniqueChars();
        System.out.println(obj.lengthOfLongestSubstringKDistinct("abcba", 2));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("aabbcc", 3));
    }

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

}


/*
Output:
—————————————————————— 

3
6



*/

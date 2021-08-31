import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Given an array of strings strs, group the anagrams together. You can return the answer in any order. LC.49
 * Approach: Sort each string and form lists in a map.
 *
 * Time complexity : O(n)
 * Space Complexity: O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2020-12-27
 */

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    // Runtime: 7ms, Memory: 53MB
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(int i=0; i<=strs.length-1; i++){
            String key = sortString(strs[i]);
            if(hm.containsKey(key)){
                List<String> temp = hm.get(key);
                temp.add(strs[i]);
                hm.put(key, temp);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                hm.put(key, temp);
            }
        }
        List<List<String>> result = new ArrayList<>(hm.values());
        return result;
    }

    private static String sortString(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return String.valueOf(charArr);
    }

}

/*
Output:
------------------------
[[eat, tea, ate], [bat], [tan, nat]]

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: Letter Combinations of a Phone Number
 * Approach: Recursion
 * While we iterate through elements find lowest buying point and then highest selling point.
 *
 * Time complexity : O(3^n)
 * Space complexity : O(n)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class PhoneLetterCombinations {

    public static void main(String[] args) {
        System.out.println(letterCombinations("364")); // dog
        System.out.println(letterCombinations("2"));
        // System.out.println(letterCombinations("2882250669")); // attack now
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(null==digits || digits.length()==0) return ans;
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0," ");    map.put(2,"abc");  map.put(3,"def");
        map.put(4,"ghi");  map.put(5,"jkl");  map.put(6,"mno");
        map.put(7,"pqrs"); map.put(8,"tuv");  map.put(9,"wxyz");
        util(map,ans,digits,new StringBuilder(""));
        return ans;
    }

    // Runtime: 0ms, Memory: 38MB
    public static void util(HashMap<Integer,String> map, List<String> ans, String digits, StringBuilder result) {
        if(digits.length()==0) {
            ans.add(result.toString());
            return;
        }
        String keys = map.get(digits.charAt(0)-'0');
        for(int i=0; i<keys.length(); i++) {
            result.append(keys.charAt(i));
            util(map,ans,digits.substring(1),result);
            result.setLength(result.length()-1);
        }
    }

}

/*
Output:
——————————————————————

[dmg, dmh, dmi, dng, dnh, dni, dog, doh, doi, emg, emh, emi, eng, enh, eni, eog, eoh, eoi, fmg, fmh, fmi, fng, fnh, fni, fog, foh, foi]

*/
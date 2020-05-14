import java.util.HashMap;

/**
 * Problem: Given two strings s and t, determine if they are isomorphic.
 *          Two strings are isomorphic if the characters in s can be replaced to get t.
 * Approach: Use HashMap or Arrays
 *
 * Time Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-05-13
 */
public class IsomorphicStrings {

    public static void main(String[] args) {

        IsomorphicStrings obj = new IsomorphicStrings();
        System.out.println(obj.isIsomorphicUsingArray("foo", "bar"));
        System.out.println(obj.isIsomorphicUsingMap("foo", "bar"));
        System.out.println(obj.isIsomorphicUsingArray("egg", "add"));
        System.out.println(obj.isIsomorphicUsingMap("egg", "add"));
    }

    // Runtime: 6ms, Memory:39.6MB
    public boolean isIsomorphicUsingMap(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        int size= s.length();
        if(size == 0 || t.length() == 0){
            return true;
        }
        HashMap<Character,Character> corr = new HashMap<>();
        for(int i = 0; i < size; i ++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(corr.containsKey(sc)){
                if(corr.get(sc) != tc){
                    return false;
                }
            }
            else{
                if(corr.containsValue(tc)){
                    return false;
                }
                else{
                    corr.put(sc,tc);
                }
            }
        }
        return true;
    }

    // Runtime: 2ms, Memory:39.3MB
    public boolean isIsomorphicUsingArray(String sString, String tString) {
        char[] s = sString.toCharArray(), t = tString.toCharArray();

        int length = s.length;
        if(length != t.length)
            return false;

        char[] sm = new char[256], tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = s[i], tc = t[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }

}


/*
Output:
——————————————————————

false
false
true
true


*/

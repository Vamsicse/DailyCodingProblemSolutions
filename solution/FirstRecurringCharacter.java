import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Find First Recurring Character
 * Approach: Use HashSet to keep track of seen characters.
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(n)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class FirstRecurringCharacter {

    public static void main(String[] args) {
        System.out.println(findFirstRecurringChar("acbbac"));
        System.out.println(findFirstRecurringChar("abcdef"));
    }


    public static Character findFirstRecurringChar(String word){
        Set<Character> seen = new HashSet<>();
        for(char c : word.toCharArray()){
            if(seen.contains(c))
                return c;
            seen.add(c);
        }
        return null;
    }

}


/*
Output:
——————————————————————
b
null

*/

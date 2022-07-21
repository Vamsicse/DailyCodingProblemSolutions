import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Problem: Pick a Random number in a given Range with BlackList.
 * Approach: Populate a Blacklist map.
             Ex: N=10, blacklist=[3,5,8,9], re-map 3 and 5 to 7 and 6.
 *
 * Time Complexity: O(B)
 * Space Complexity: O(B)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class RandomPickWithBlackList {

    int M;
    Random r;
    Map<Integer, Integer> map;

    public RandomPickWithBlackList(int N, int[] blacklist) {
        map = new HashMap<>();
        for (int b : blacklist) // O(B)
            map.put(b, -1);
        M = N - map.size();
        for (int b : blacklist) { // O(B)
            if (b < M) { // re-mapping
                while (map.containsKey(N - 1))
                    N--;
                map.put(b, N - 1);
                N--;
            }
        }
        r = new Random();
    }

    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }

    public static void main(String[] args) {
        RandomPickWithBlackList randomPickWithBlackList = new RandomPickWithBlackList(10, new int[]{1,10});
        System.out.println(randomPickWithBlackList.pick());
    }

}


/*
Output:
—————————————————————— 

9



*/

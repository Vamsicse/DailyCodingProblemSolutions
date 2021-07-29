/**
 * Problem: Super Egg Drop. LC: 887
 *      You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
 *      You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.
 *      Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n).
 *      If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
 *      Return the minimum number of moves that you need to determine with certainty what the value of f is.
 * Approach: https://leetcode.com/problems/super-egg-drop/solution/
 *      We have t tries and K eggs, the result of our t throws must be a t-length sequence of successful and failed throws, with at most K failed throws.
 *      Hence, we can only distinguish at most these many floors in tt tries (as each sequence can only map to 1 answer per sequence.)
 *      This process includes distinguishing F = 0F=0, so that the corresponding value of NN is one less than this sum.
 *      However, this is also a lower bound for the number of floors that can be distinguished, as the result of a throw on floor XX will bound the answer to be either at most XX or greater than XX.
 *      Hence, in an optimal throwing strategy, each such sequence actually maps to a unique answer.
 *      We binary search for the correct t.
 *
 * Time complexity : O(K*logN)
 * Space complexity : O(1)
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2021-05-13
 */
public class EggDrop {

    public static void main(String[] args) {
        System.out.println(superEggDrop(1,2));
        System.out.println(superEggDrop(2,6));
        System.out.println(superEggDrop(3,14));
        System.out.println(superEggDrop(1,5));
    }

    // Runtime: 0ms, Memory: 35.8MB
    private static int superEggDrop(int K, int N) {
        int lo = 1, hi = N;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (f(mi, K, N) < N)
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    private static int f(int x, int K, int N) {
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i) {
            r *= x-i+1;
            r /= i;
            ans += r;
            if (ans >= N) break;
        }
        return ans;
    }

}

/*
Output:
——————————————————————
2
3
4
5

*/
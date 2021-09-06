import java.util.Random;

/**
 * Problem: You have n fair coins and you flip them all at the same time. Any that come up tails you set aside.
 *          The ones that come up heads you flip again. How many rounds do you expect to play before only one coin remains
 * Approach: Iteration until 1 coin is left.
 *
 * Space Complexity: O(1)
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2020-12-27
 */
public class CoinGame {

    public static void main(String[] args) {
        int coins = 100;
        System.out.println("Expected rounds to play: " + coinCounter(coins));
    }

    private static int coinCounter(int totalCoins) {
        int totalRounds = 0;
        int coinsToFlip = totalCoins;
        while (coinsToFlip > 1) {
            int coins = coinsToFlip;
            for (int i = 0; i < coins; ++i) {
                if (getRandomHeadOrTail().equals("Tail")) {
                    --coinsToFlip;
                }
            }
            ++totalRounds;
        }
        return totalRounds;
    }

    private static String getRandomHeadOrTail(){
        return (new Random().nextInt(100)>49)?"Head":"Tail";
    }

}


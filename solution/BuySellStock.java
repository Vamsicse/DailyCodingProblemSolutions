import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BuySell Stock Problem
 * Approach: One-pass
 * While we iterate through elements find lowest buying point and then highest selling point.
 *
 * Time complexity : O(n). We traverse the list containing n elements only once.
 * Space complexity : O(1). Space is required to store buying and selling point.
 *
 * @author  Vamsi Krishna Myalapalli
 * @since   2019-12-27
 */
public class BuySellStock {

    public static void main(String[] args) {
        System.out.println("Max Profit Single Buy and Sell: " + maxProfit(new int[]{176, 72, 32, 100, 76}));
        List<Integer> list = Arrays.asList(5, 2, 4, 0, 1);
        int k=2;
        System.out.println("Max Profit " + k + " times Buy and Sell: " + maxKPairsProfits(list,k));
        System.out.println("Max Profit Multiple Buy and Sell with fee: " + maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println("Max Profit Multiple Buy and Sell with fee: " + maxProfit(new int[]{1,3,7,5,10,3}, 3));
    }

    // Maximum profit from 1 buy and sell
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

    // Maximum profit from 'k' buys and sells
    public static int maxKPairsProfits(List<Integer> A, int k) {
        List<Integer> kSum = new ArrayList<>();
        for (int i = 0; i < k * 2; ++i) {
            kSum.add(Integer.MIN_VALUE);
        }
        for (int i = 0; i < A.size(); ++i) {
            List<Integer> preKSum = new ArrayList<>(kSum);
            for (int j = 0, sign = -1; j < kSum.size() && j <= i; ++j, sign *= -1) {
                int diff = sign * A.get(i) + (j == 0 ? 0 : preKSum.get(j - 1));
                kSum.set(j, Math.max(diff, preKSum.get(j)));
            }
        }
        // Returns the last selling profits as the answer. return kSum.get(kSum.size() - 1);
        return kSum.get(kSum.size() - 1);
    }

    // Find max profit by trading multiple times with a fee
    // Runtime: 2ms, Memory: 48MB
    public static int maxProfit(int[] prices, int fee) {
        if(prices == null) return 0;
        int cash = 0, hold = -prices[0], oldCash;
        for(int i=1; i<prices.length; i++){
            oldCash = cash;
            cash = Math.max(cash, hold+prices[i]-fee);
            hold = Math.max(hold, oldCash-prices[i]);
        }
        return cash;
    }
}


/*
Output:
——————————————————————

Max Profit Single Buy and Sell: 68
Max Profit2 times Buy and Sell: 3


*/

/**
 * BuySell Stock Problem
 * Approach: One-pass
 * While we iterate through elements find lowest buying point and then highest selling point.
 *
 * Time complexity : O(n). We traverse the list containing n elements only once.
 * Space complexity : O(1). Space is required to store buying and selling point.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class BuySellStock {

    public static void maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        int sell=0;
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            else if (prices[i] - buy > maxProfit) {
                sell = prices[i];
                maxProfit = sell - buy;
            }
        }
        System.out.println("Max profit is: " + maxProfit);
        System.out.println("Buy at: " + buy + ". Sell at: " + sell);
    }

    public static void main(String[] args) {
        maxProfit(new int[] {176,72,32,100,76});
    }
}

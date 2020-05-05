/**
 * BuySell Stock Problem
 * Approach: One-pass
 * While we iterate through elements find lowest buying point and then highest selling point.
 *
 * Time complexity : O(n). We traverse the list containing n elements only once.
 * Space complexity : O(1). Space is required to store profit point.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class BuySellStock {

    public static void maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxProfit)
                maxProfit = prices[i] - minprice;
        }
        System.out.println("Max profit is: " + maxProfit);
    }

    public static void main(String[] args) {
        maxProfit(new int[] {176,72,32,100,76});
    }
}



/*
Output:
—————————
Max profit is: 68

*/

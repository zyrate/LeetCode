package problems;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class p122_best_time_to_buy_and_sell_stock_ii {
    
    /**
     * 虽然是个中等题，但主要难在思维
     * 买股票的最优解其实就是每次涨幅都变成自己的收益
     * 因为可以在同一天买卖（现实不行），那么如果明天涨了，那么明天就必须出售，否则今天到明天的这部分涨幅就浪费了
     * 所以最后转化成把所有相邻的涨幅全部加起来
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0, j = 1; i < prices.length && j < prices.length; i++, j++) {
            if (prices[j] > prices[i]) {
                max += prices[j] - prices[i];
            }
        }
        return max;
    }    
}
package problems;
/**
 * 买卖股票的最佳时机
 */
public class p121_best_time_to_buy_and_sell_stock {
    
    /**
     * 每次遇到当前最大的，就更新最大值，并计算一次可得收益
     * 每次遇到当前最小的，就更新最大最小值 - 因为之前的最大值用不上了
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max, min, maxProfit;
        max = min = prices[0];
        maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(max < prices[i]){
                max = prices[i];
                if(max - min > maxProfit){
                    maxProfit = max - min;
                }
            }
            if(min > prices[i]){
                min = prices[i];
                max = prices[i];
            }
        }
        return maxProfit;
    }

    /**
     * 上面的还是复杂化了，max是多余的，它的存在只是为了和min相减计算maxProfit
     * 因此可以只保留maxProfit，即“最大差值”
     * 贪心算法
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int maxProfit = 0, min = prices[0];
        for(int i=1; i<prices.length; i++){
            min = Math.min(prices[i], min);
            maxProfit = Math.max(prices[i]-min, maxProfit);
        }
        return maxProfit;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices){
        int len = prices.length;
        if(len == 0) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for(int i=1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
        }
        return dp[len-1][1];
    }

}

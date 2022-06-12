class Solution {
    public int maxProfit(int[] prices) {
        int cost = prices[0], profit = 0, len = prices.length;
        
        for (int i = 1; i < len; i++) {
            if (prices[i] > cost)
                profit += prices[i] - cost;
            
            cost = prices[i];
        }
        
        return profit;
    }
}
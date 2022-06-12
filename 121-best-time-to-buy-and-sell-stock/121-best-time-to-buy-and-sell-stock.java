class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) return 0;
        
        int left = 0, right = 1, maxDiff = Integer.MIN_VALUE;
        while (right < len) {
            if (prices[left] > prices[right])
                left++;
            else
                maxDiff = Math.max(prices[right++] - prices[left], maxDiff);
        }
        
        return maxDiff;
    }
}
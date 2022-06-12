class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] arr = new int[len + 2][2];
        int i, j;
        
        for (i = len - 1; i >= 0; i--) {
            for (j = 0; j <= 1; j++) {
                arr[i][j] = (j == 1)
                    ? Math.max(arr[i + 1][0] - prices[i], arr[i + 1][1])
                    : Math.max(arr[i + 2][1] + prices[i], arr[i + 1][0]);
            }
        }
        
        return arr[0][1];
    }
}
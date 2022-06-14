class Solution {
    public int maxProfit(int[] prices, int fee) {
        int noStock = 0, stock = Integer.MIN_VALUE;
        int tempNoStock, tempStock;

        for (int price : prices) {
            tempNoStock = Math.max(noStock, stock + price);
            tempStock = Math.max(stock, (noStock - price - fee));

            noStock = tempNoStock;
            stock = tempStock;
        }

        return noStock;
    }
}
/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */
var maxProfit = function(prices, fee) {
    let noStock = 0, stock = -Infinity
    
    for (let price of prices) {
        let tempNoStock = Math.max(noStock, stock + price)
        let tempStock = Math.max(stock, (noStock - price - fee))
        
        noStock = tempNoStock
        stock = tempStock
    }
    
    return noStock
};
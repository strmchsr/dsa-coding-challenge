package com.androidiots.coding.datastructure.array


/**
 * We’re given an array of daily stock prices (integers for simplicity).
 * Return the buying and selling prices for making the maximum profit.
 * [7,1,5,3,6,4]
 * 1,6 - Output]
 */


class StockPrices {

    fun findBuySellStockPrices(stockNums: IntArray) {
        var currentBuy = stockNums[0]
        var globalSell = stockNums[1]
        var globalProfit = globalSell - currentBuy
        for (index in 1 until stockNums.size) {
            var currentProfit = stockNums[index] - currentBuy
            if (currentProfit > globalProfit) {
                globalProfit = currentProfit
                globalSell = stockNums[index]
            }

            if (stockNums[index] < currentBuy) {
                currentBuy = stockNums[index]
            }
        }

        println("For maximum profit buy : ${globalSell-globalProfit} sell:$globalSell")

    }
}

fun main() {
    StockPrices().findBuySellStockPrices(intArrayOf(8, 6, 5, 4, 3, 2, 1))
    StockPrices().findBuySellStockPrices(intArrayOf(1, 2, 3, 4, 3, 2, 1, 2, 5))
    StockPrices().findBuySellStockPrices(intArrayOf(12, 30, 40, 90, 110))
}
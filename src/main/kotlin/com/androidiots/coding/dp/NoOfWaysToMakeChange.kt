package com.androidiots.coding.dp

/**
 *
Given an array of distinct positive integers representing coin denominations and a
single non-negative integer,  representing a target amount of
money, write a function that returns the number of ways to make change for
that target amount using the given coin denominations.
<p>Note that an unlimited amount of coins is at your disposal.</p>
 Sample Input : denom = [1,5] n =6
 Sample Output :2
 */
fun numberOfWaysToMakeChange(n: Int, denoms: List<Int>): Int {
    // Write your code here.
    //
    val ways = IntArray(n + 1) { _ -> 0 }
    ways[0] = 1
    for(denom in denoms){
        for ( amount in 0..n ){
            if(denom <= amount){
              ways[amount] = ways[amount]+ways[amount - denom]

            }
            println("freqMap for ${amount}: ${ways[amount]}")
        }
    }
    return ways[n]
}

fun main() {
    val denoms = listOf(2,4)
    val output = numberOfWaysToMakeChange(7, denoms)
    println("Answer is: $output")
}

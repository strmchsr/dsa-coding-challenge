package com.androidiots.coding.recursion

import java.util.*

fun main() {
    println("No of ways: ${countWays(10)}")
}
fun countWays(n : Int):Int{
    var memo : IntArray = IntArray(n+1){
        -1
    }
    return countWays(n,memo)
}

private fun countWays(n : Int, memo : IntArray): Int{
    if(n<0){
        return 0
    } else if (n== 0){
        return 1
    } else if (memo[n] >-1){
        return memo[n]
    } else {
        return countWays(n-1, memo)+ countWays(n-2, memo)+ countWays(n-3,memo)
    }
}
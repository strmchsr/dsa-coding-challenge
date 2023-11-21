package com.androidiots.coding.datastructure.array

import kotlin.math.min

fun minNumberOfCoinsForChange(n: Int, denoms: List<Int>): Int {
    // Write your code here.
    val numbers = IntArray(n + 1) { _ -> Int.MAX_VALUE }
    numbers[0] = 0
    denoms.forEach { denom ->
        run {
            for (num in 0..n) {
                if (denom <= num) {
                    numbers[num] = min(numbers[num], 1 + numbers[num - denom])
                }
            }
        }
    }
    return if (numbers[n] == Int.MAX_VALUE) {
        -1
    } else {
        numbers[n]
    }
}

fun main() {
    val denoms = listOf(2, 1)
    val output = minNumberOfCoinsForChange(3, denoms)
    println(output)
}
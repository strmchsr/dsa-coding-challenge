package com.androidiots.coding.datastructure.algorithms

import kotlin.math.max


/**
 *
 */
fun kadanesAlgorithm(array: List<Int>): Int {
    var currentSum = array[0]
    var maxSumSoFar = array[0]
    for (i in 1 until array.size) {
        currentSum = max(currentSum+array[i],array[i])
        maxSumSoFar = max(maxSumSoFar,currentSum)
    }
    return maxSumSoFar
}

fun main() {
    println(kadanesAlgorithm(listOf(3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4)))
}

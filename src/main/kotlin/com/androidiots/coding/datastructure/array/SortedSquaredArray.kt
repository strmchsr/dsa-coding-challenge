package com.androidiots.coding.datastructure.array

import kotlin.math.abs

class SortedSquaredArray {

    fun sortedSquaredArray(array: List<Int>): List<Int> {
        // Write your code here.
        val sortedSquares = array.map { _ -> 0 }.toMutableList()
        var start = 0
        var end = array.size - 1

        for (index in array.size - 1 downTo 0) {
            if (abs(array[start]) > abs(array[end])) {
                sortedSquares[index] = array[start] * array[start]
                start+=1
            } else {
                sortedSquares[index] = array[end] * array[end]
                end-=1
            }
        }

        return sortedSquares
    }
}

fun main() {
    var output = SortedSquaredArray()
    print(output.sortedSquaredArray(mutableListOf(1, 2, 3, 5, 6, 8, 9)))
}
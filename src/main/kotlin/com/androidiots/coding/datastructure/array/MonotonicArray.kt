package com.androidiots.coding.datastructure.array


fun isMonotonic(array: List<Int>): Boolean {
    // Write your code here.
    var isNonIncreasing = true
    var isNonDecreasing = true

    for (index in 1 until array.size) {
        if (array[index] > array[index - 1]) {
            isNonDecreasing = false
        }

        if (array[index] < array[index - 1]) {
            isNonIncreasing = false
        }
    }

    return isNonDecreasing || isNonIncreasing
}

fun main() {
    println(isMonotonic(mutableListOf(-1, -5, -10, -1100, -1100, -1101, -1102, -9001)))
}

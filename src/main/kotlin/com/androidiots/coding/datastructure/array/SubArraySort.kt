package com.androidiots.coding.datastructure.array


/**
 * Time Complexity O(n)
 * Space O(1)
 */
fun subarraySort(array: List<Int>): List<Int> {
    var minOutOfOrder = Int.MAX_VALUE
    var maxOutOfOrder = Int.MIN_VALUE

    array.forEachIndexed { index, value ->
        if (isOutOfOrder(value = value, array = array, index = index)) {
            minOutOfOrder = minOf(array[index], minOutOfOrder)
            maxOutOfOrder = maxOf(array[index], maxOutOfOrder)
        }
    }

    if (minOutOfOrder == Int.MAX_VALUE) {
        return listOf<Int>(-1, -1)
    }

    println("minOutOfOrder: $minOutOfOrder")
    println("maxOutOfOrder: $maxOutOfOrder")

    var subArrayLeftIdx = 0
    while (minOutOfOrder > array[subArrayLeftIdx]) {
        subArrayLeftIdx += 1
    }

    var subArrayRightIdx = array.size - 1
    while (maxOutOfOrder < array[subArrayRightIdx]) {
        subArrayRightIdx -= 1
    }

    return listOf<Int>(subArrayLeftIdx, subArrayRightIdx)
}

fun isOutOfOrder(value: Int, index: Int, array: List<Int>): Boolean {
    return when (index) {
        0 -> {
            value > array[index + 1]
        }
        array.size - 1 -> {
            value < array[index - 1]
        }
        else -> {
            value > array[index + 1] || value < array[index - 1]
        }
    }
}

fun main() {
    println(subarraySort(listOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19)))
}

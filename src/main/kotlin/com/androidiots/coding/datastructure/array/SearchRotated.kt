package com.androidiots.coding.datastructure.array

object SearchRotated {

    fun binarySearchRotated(input: IntArray, target: Int): Int {
        return binarySearch(input, 0, input.size - 1, target)

    }

    private fun binarySearch(input: IntArray, start: Int, end: Int, target: Int): Int {
        if (start > end) {
            return -1
        }

        val mid = start + (end - start) / 2
        if (input[mid] == target) {
            return mid
        }

        return if (input[mid] < input[end]) {
            if (target > input[mid] && target <= input[end]) {
                binarySearch(input, mid, end, target)
            } else {
                binarySearch(input, start, mid - 1, target)
            }
        } else {
            if (target < input[mid] && target >= input[start]) {
                binarySearch(input, start, mid, target)
            } else {
                binarySearch(input, mid + 1, end, target)
            }
        }

    }
}

fun main() {
    val targetList = intArrayOf(3,6,2,6)
    var numLists = arrayOf(intArrayOf(6, 7, 1, 2, 3, 4, 5), intArrayOf(6, 7, 1, 2, 3, 4, 5), intArrayOf(4, 5, 6, 1, 2, 3), intArrayOf(4, 5, 6, 1, 2, 3))

    for ((index, target) in targetList.withIndex()){
        println("$target found at index : ${SearchRotated.binarySearchRotated(numLists[index],target)}")
        println(
            "----------------------------------------------------------------------------------------------------\n");
    }
}
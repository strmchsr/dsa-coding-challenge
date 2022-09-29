package com.androidiots.coding

class PairWithTargetSum {
    fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
        // Write your code here.
        var set = mutableSetOf<Int>()
        for (number in array) {
            if (set.contains(targetSum - number)) {
                return listOf(number, targetSum - number)
            } else {
                set.add(number)
            }
        }
        return listOf<Int>()
    }
}

class PairWithTargetSumWithIndex {
    fun twoNumberSum(array: MutableList<Int>, targetSum: Int): IntArray {
        // Write your code here.
        var map = mutableMapOf<Int, Int>()
        for ((index, number) in array.withIndex()) {
            if (map.containsKey(targetSum - number)) {
                return intArrayOf(index, map[targetSum - number]!!)
            } else {
                map[number] = index
            }
        }
        return intArrayOf()
    }
}

fun main() {
    var pairWithTargetSum = PairWithTargetSumWithIndex()
    var output = pairWithTargetSum.twoNumberSum(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10)
    println(output)
}
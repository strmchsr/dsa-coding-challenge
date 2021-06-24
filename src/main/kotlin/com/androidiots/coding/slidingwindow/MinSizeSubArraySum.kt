package com.androidiots.coding.slidingwindow

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 * Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 */
object MinSizeSubArraySum {
    fun minSubArraySize(input: IntArray, targetSum: Int): Int {
        var size = 0
        var windowStart = 0
        var windowSum = 0
        for ((index, value) in input.withIndex()) {
            windowSum += value
            size++
            while (windowSum>targetSum){
                windowSum-=input[windowStart]
                size--
                windowStart++
            }
            if(windowSum == targetSum){
                return size
            }

        }
        return size
    }
}
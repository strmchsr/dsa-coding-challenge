package com.androidiots.coding.slidingwindow

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 */
object MaxSumSubArrayOfSizeK {
    fun maxSum(input: IntArray, k: Int): Int {
        var maxSum = 0
        var index = 0
        for (value in input) {
            var currentSum = 0
            for (i in 0 until k) {
                currentSum += input[i]
            }
            if (maxSum < currentSum) {
                maxSum = currentSum
            }
        }
        index++
        return maxSum
    }

    fun maxSumSlidingWindow(input: IntArray, k: Int): Int {
        var maxSum = 0
        var windowStart = 0
        var windowSum = 0
        for ((index, value) in input.withIndex()) {
           windowSum+=value
            if(index>=k-1){
                maxSum = maxSum.coerceAtLeast(windowSum)
                windowSum-=input[windowStart]
                windowStart++
            }
        }
        return maxSum
    }
}
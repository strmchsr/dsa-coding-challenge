package com.androidiots.coding.datastructure.array

/*
Solution: Kadane’s Algorithm#
This algorithm takes a dynamic programming approach to solve the maximum subarray sum problem. Let’s have a look at the algorithm.
 */

class MaxContiguousSum {
    fun findMaxSumSubArray(input : IntArray):Int{
        var currSum = input[0]
        var maxSum = input[0]
        for (index in 1 until input.size){
            if(currSum < 0){
                currSum = input[index]
            } else {
                currSum+=input[index]
            }

            if(currSum>maxSum){
                maxSum = currSum
            }
        }

        return maxSum
    }
}

fun main() {
    print("MaxSum ${MaxContiguousSum().findMaxSumSubArray(intArrayOf(-2, 7, -2, -5, 10, -1))}")
}
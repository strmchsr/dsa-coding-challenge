package com.androidiots.coding.datastructure.array

object MaxSumContiguiusArrK {

    fun findMaxSumSubArray(input : IntArray, k : Int){
        var windowStart = 0
        var windowSum = 0
        var maxSum = 0
        for ((index, value) in input.withIndex()){
            windowSum+=value
            if(index>=k){
                windowSum-=input[windowStart++]
            }

            if(windowSum>=maxSum){
                maxSum = windowSum
                println("-------- curr max sum : $maxSum")
            }
        }

        println("-------- /n max sum : $maxSum")
    }


}

fun main() {
    MaxSumContiguiusArrK.findMaxSumSubArray(intArrayOf(2, 1, 5, 1, 3, 2), 3)
}
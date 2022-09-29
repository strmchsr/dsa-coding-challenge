package com.androidiots.coding.datastructure.array

/**
 *  Break down in 2 steps problem
 *  1. fina all the peaks by just iterating the array (peak - it should be grater than both side adjacent value)
 *  2. find the length of all peaks
 *
 *  Time Complexity : O(n)
 */
fun longestPeak(array: List<Int>): Int {
    var longestPeakLength = 0
    var index = 1
    while(index<array.size-1){
        var isPeak = array[index]>array[index-1] && array[index]>array[index+1]
        if(!isPeak){
            index++
            continue
        }
        var leftIndex = index -2

        while (leftIndex>=0 && array[leftIndex]<array[leftIndex+1]){
            leftIndex--
        }

        var rightIndex = index+2

        while (rightIndex<array.size && array[rightIndex]<array[rightIndex-1]){
            rightIndex++
        }

        var currentLength = rightIndex-leftIndex-1
        if(currentLength>longestPeakLength){
            longestPeakLength = currentLength
        }
        index = rightIndex
    }
    return longestPeakLength
}


fun main() {
    println(longestPeak(listOf(1,2,3,4,5,1)))
}

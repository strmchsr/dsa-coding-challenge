package com.androidiots.coding.datastructure.array

object FindMinimum {
    fun findMinimum(inputArr:IntArray):Int{
        var min = Int.MAX_VALUE
        for (value in  inputArr){
            if(min > value){
                min = value
            }
        }
        return min
    }
}

fun main() {
    print(FindMinimum.findMinimum(intArrayOf(9,2,3,6)))
}
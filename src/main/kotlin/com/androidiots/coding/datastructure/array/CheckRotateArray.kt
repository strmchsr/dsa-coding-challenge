package com.androidiots.coding.datastructure.array

/**
 * In this problem, you have to implement the void rotateArray(int[] arr) method, which takes an arr and
 * rotate it right by 1. This means that the right-most elements will appear at the left-most position in the array.
 */


object CheckRotateArray {

    fun rightRotateArray(inputArray : IntArray):Array<Int>{
        val k = 3
        var resultArray = Array(inputArray.size) { i -> inputArray[i] }
        val inputLength = inputArray.size
        for ((i, item) in inputArray.withIndex()){
            if (i< inputLength-k){
                resultArray[i+k] = item
            } else {
                val newIndex = (i+k)%inputLength
                resultArray[newIndex] = item
            }
        }
        return resultArray
    }
}

fun main() {
    val res = CheckRotateArray.rightRotateArray(intArrayOf(1, 2, 3, 4, 5))
    val list = mutableListOf<Int>()
    for(value in res){
        list.add(value)
    }
    print(list)
}
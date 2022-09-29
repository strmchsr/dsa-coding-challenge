package com.androidiots.coding.datastructure.array

import kotlin.math.abs


//using set
//linear time and constant space
// given we can mutate the array and numbers are between 1 to n
fun firstDuplicateValueOptimal(array: MutableList<Int>): Int {
    array.forEach { value ->
        val absValue = abs(value)
        if(array[absValue - 1]<0){
            return value
        }
        array[absValue - 1]*=-1
    }
    return -1
}

//using set
//O(n) time O(n) space
fun firstDuplicateValue(array: MutableList<Int>): Int {
    // Write your code here.
    var seen = mutableSetOf<Int>()
    array.forEachIndexed { idx, value ->
        var isAdded = seen.add(value);
        if(!isAdded){
            return array[idx]
        }
    }
    return -1
}

fun main() {
    println("first duplicate: ${firstDuplicateValueOptimal(mutableListOf(2,1,5,2,3,3,4))}")
}

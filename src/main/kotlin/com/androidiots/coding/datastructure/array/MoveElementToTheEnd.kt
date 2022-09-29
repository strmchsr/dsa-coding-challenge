package com.androidiots.coding.datastructure.array


/**
 * can be solved using two pointers approach
 */
fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    var read = 0
    var write = array.size - 1
    while (read < write) {
        //we are decrementing write pointer in while loop till then we are getting the write value is equal to the element we are moving
        while (read < write && array[write] == toMove) {
            write--
        }
        if (array[read] == toMove && array[write] != toMove) {
            array[read] = array[write]
            array[write] = toMove

        }
        read++
    }
    return array
}

fun main() {
    println(moveElementToEnd(mutableListOf(2,1,2,2,2,3,2,2),2))
}
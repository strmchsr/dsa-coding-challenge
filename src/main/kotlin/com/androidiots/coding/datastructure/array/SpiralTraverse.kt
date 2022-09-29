package com.androidiots.coding.datastructure.array


/**
 * we will perimeter by perimeter approach
 */

fun spiralTraverse(array: List<List<Int>>): List<Int> {

    var result = mutableListOf<Int>()
    var startRow = 0
    var endRow = array.size - 1
    var startColumn = 0
    var endColumn = array[0].size - 1
    var count = 0
    val totalItems = array.size * (array[0].size)
    while (count < totalItems) {
        //top
        if (count < totalItems) {
            for (i in startColumn..endColumn) {
                result.add(array[startRow][i])
                count++
            }
            startRow++
        }


        //right
        if (count < totalItems) {
            for (i in startRow..endRow) {
                result.add(array[i][endColumn])
                count++
            }
            endColumn--
        }


        //bottom
        if (count < totalItems) {
            for (i in endColumn downTo startColumn) {
                result.add(array[endRow][i])
                count++
            }
            endRow--
        }


        //left
        if (count < totalItems) {
            for (i in endRow downTo startRow) {
                result.add(array[i][startColumn])
                count++
            }
            startColumn++
        }

    }


    return result
}

fun main() {
    println(
        spiralTraverse(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(12, 13, 14, 5),
                listOf(11, 16, 15, 6),
                listOf(10, 9, 8, 7)
            )
        )
    )
}
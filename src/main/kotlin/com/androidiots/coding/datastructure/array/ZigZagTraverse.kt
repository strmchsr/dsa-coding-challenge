package com.androidiots.coding.datastructure.array


/**
 *   m
 */

fun zigzagTraverse(array: List<List<Int>>): List<Int> {
    // Write your code here.
    val result = mutableListOf<Int>()
    var height = array.size -1
    var width = array[0].size - 1
    var row = 0;
    var column = 0
    var isGoingDown = true
    while (!isIndexOutOfBound(row = row, height = height, column = column, width = width)){
        result.add(array[row][column])
        if(isGoingDown){
            if (column == 0 || row == height){
                isGoingDown = false
                //the sequence of if and else in important here
                if(row == height){
                    column+=1

                } else {
                    row+=1
                }
            } else {
                row+=1
                column-=1
            }
        } else {
            if(row == 0 || column == width){
                isGoingDown = true
                //the sequence of if and else in important here
                if(column == width){
                    row += 1

                } else {
                    column += 1
                }
            } else {
                column += 1
                row -= 1
            }
        }
    }
    return result
}

fun isIndexOutOfBound(row:Int,height:Int,column:Int,width:Int):Boolean{
    return row<0 || row>height || column<0 || column>width
}

fun main() {
    println(
        zigzagTraverse(
            listOf(
                listOf(1,3,4,10),
                listOf(2,5,9,11),
                listOf(6,8,12,15),
                listOf(7,13,14,16)
            )
        )
    )
}

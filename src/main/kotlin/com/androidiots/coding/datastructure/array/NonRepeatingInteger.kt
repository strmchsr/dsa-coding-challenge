package com.androidiots.coding.datastructure.array

/**
 * In this problem, you have to implement the int findFirstUnique(int[] arr) method that will look for a first unique integer,
 * which appears only once in the whole array. The function returns -1 if no unique number is found.
 * Sample Input #
arr = {9, 2, 3, 2, 6, 6}
Sample Output #
9
 */
object NonRepeatingInteger {

    //we can solve this using hashmap
    fun findFirstUnique(inputArray : IntArray):Int{
        var unique = -1
        var freqMap = mutableMapOf<Int,Int>()
        for (item in inputArray){
            if (freqMap.containsKey(item)){
                freqMap[item] = freqMap[item]!! + 1
            } else {
                freqMap[item] = 0
            }
        }

        for ((index, item) in inputArray.withIndex()){
            if (freqMap[item] == 0){
                return inputArray[index]
            }
        }
        return unique
    }
}

fun main() {
    print(NonRepeatingInteger.findFirstUnique(intArrayOf(6, 4, 3, 2, 6, 6)))
}
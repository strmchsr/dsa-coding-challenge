package com.androidiots.coding.datastructure.array

/**
 * In this problem, you have to implement the int[] findProduct(int[] arr)
 * method which will modify arr in such a way that in the output,
 * each index i will contain the product of all elements present
 * in arr except the element stored on that index i.
 *
 * Sample Input#
 * arr = {1,2,3,4}
 * Sample Output#
 * arr = {24,12,8,6}
 */

object ProductArray {
    // Brute force Approach
    fun findProduct(inputArray: Array<Int>): Array<Int> {
        val resultArray = Array(inputArray.size) { 0 }
        for ((i, input) in inputArray.withIndex()) {
            var k = 0
            var prod = 1
            while (k < inputArray.size) {
                if (i != k) {
                    prod *= inputArray[k]
                }
                k++
            }
            resultArray[i] = prod
        }
        return resultArray
    }

    // Optimized Approach
    fun findProductOptimized(inputArray: List<Int>): List<Int> {
        var resultArray = mutableListOf<Int>()
        var i = 0
        var prod = 1
        while (i<inputArray.size){
            resultArray.add(i,prod)
            prod*=inputArray[i]
            i++
        }
        var j = inputArray.size
        prod = 1
        while (j>0){
            resultArray[j-1] *=prod
            prod*=inputArray[j-1]
            j--
        }
        return resultArray
    }
}

fun main() {
    val res = ProductArray.findProductOptimized(listOf(1,2,3,4,5,6,7,8,9,3,23,54))
    val list = mutableListOf<Int>()
    for(value in res){
        list.add(value)
    }
    print(list)
}






















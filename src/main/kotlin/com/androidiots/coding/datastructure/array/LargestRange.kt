package com.androidiots.coding.datastructure.array


/**
 * Approach 1 : Sort the array , then iterate and check if at each index the value is +1 than previous one : O(nlogn)
 * Approach 2 : Pull all the no in hashmap (T= o(n), s= O(n))
 */
fun largestRange(array: List<Int>): Pair<Int, Int> {
    // Write your code here.
    var exploredMap = mutableMapOf<Int, Boolean>()
    var maxLength = 0
    var pair = Pair<Int,Int>(-1,-1)
    //initialized map to true
    for(num in array){
        exploredMap[num] = true
    }
    for (num in array){
        var currentLength = 0
        if(exploredMap[num] == false){
            continue
        }
        exploredMap[num] = false
        currentLength = 1
        var left = num -1
        while (exploredMap[left] == true){
            currentLength++
            exploredMap[left] = false
            left -= 1
        }
        var right = num + 1
        while (exploredMap[right] == true){
            currentLength++
            exploredMap[right] = false
            right += 1
        }
        if(currentLength>maxLength){
            maxLength = currentLength
            pair = Pair<Int,Int>(left + 1, right - 1)
        }

    }
    return pair
}

fun main() {
    println("Pair : ${largestRange(listOf(1))}")
}

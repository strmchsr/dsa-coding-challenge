package com.androidiots.coding.slidingwindow

/**
 * Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 */
object MaxFruitCountOf2Types {
    fun findLength(arr: CharArray): Int {
       var frequencyMap = mutableMapOf<Char,Int>()
        var windowStart = 0
        var maxLength = 0
        var arrStartLength = 0
        var arrEndLength = 0
        for ((index, value) in arr.withIndex()) {
            println(value.toInt())
            if(frequencyMap.containsKey(arr[index])){
                frequencyMap[arr[index]] = frequencyMap[arr[index]]!!+1
            } else {
                frequencyMap[arr[index]] = 1
            }

            while (frequencyMap.size > 2) {
                frequencyMap[arr[windowStart]] =  frequencyMap[arr[windowStart]]!!-1
                if(frequencyMap[arr[windowStart]] == 0){
                    frequencyMap.remove(arr[windowStart])
                }
                windowStart++
            }
            val currentLength = index - windowStart + 1
            if(currentLength>maxLength){
                maxLength = currentLength
                arrStartLength = windowStart
                arrEndLength = index
            }

        }

        println("Max length of $arr with not more than 2 distinct character is $maxLength and array is ${arr.copyOfRange(arrStartLength,arrEndLength+1).contentToString()}")

        return maxLength
    }
}
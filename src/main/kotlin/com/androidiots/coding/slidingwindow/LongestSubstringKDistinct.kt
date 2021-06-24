package com.androidiots.coding.slidingwindow

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
 */
object LongestSubstringKDistinct {
    fun longestSubstringKDistinct(input: String, k: Int): Int {
        val values = BooleanArray(128)
        var windowStart = 0
        var maxLength = 0
        var inputCharArr = input.toCharArray()
        for ((index, value) in inputCharArr.withIndex()) {
            println(value.toInt())
            if (!values[value.toInt()]) {
                values[value.toInt()] = true
            }
            val distinctChars = values.filter {
                it
            }
            if (distinctChars.size > k) {
                values[inputCharArr[windowStart].toInt()] = false
                windowStart++
            }
            maxLength = Math.max(maxLength,index-windowStart+1)

        }

        println("Max length of $input with not more than $k distinct character is $maxLength")

        return maxLength
    }
}
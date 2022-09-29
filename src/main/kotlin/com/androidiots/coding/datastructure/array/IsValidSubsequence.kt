package com.androidiots.coding.datastructure.array

class IsValidSubsequence {
    fun isValidSubsequenceBrute(array: List<Int>, sequence: List<Int>): Boolean {
        var count = 0
        for (num in array){
            if(sequence[count] == num){
                count++
            }
        }
        return count == sequence.size
    }

    fun isSubsequence(s: String, t: String): Boolean {
            var count = 0
            for(char in t.toCharArray()){
                if(count<s.length && s.toCharArray()[count] == char){
                    count++
                }
            }
        return  count == s.length
    }

}

fun main() {
    var isValidSubsequence = IsValidSubsequence()
    print(isValidSubsequence.isValidSubsequenceBrute(arrayListOf(5, 1, 22, 25, 6, -1, 8, 10), arrayListOf(1, 6, -1, 10)))

    print(isValidSubsequence.isSubsequence("axc", "ahbgdc"))

}
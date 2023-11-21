package com.androidiots.coding.slidingwindow


fun main() {
    val input = arrayListOf("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC", "GGGGGGGGGGGGGGGGGGGGGGGGG",
        "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
        "", "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT")

    val inputK = arrayListOf(3, 3, 8, 12, 10, 14, 10, 10, 6)
    for ((i, k) in inputK.withIndex()){
        findRepeatedSequence(input[i],k)
    }

}

//naive solution
fun findRepeatedSequence(s:String, k:Int): String {

    var start = 0
    var end = k
    val inputArr = s.toCharArray()
    var sequenceListMap = mutableMapOf<String, Int>()
    while (end < inputArr.size+1){
        sequenceListMap[s.substring(start,end)] = -1
        start++
        end++
    }
    var index = 0
    var outputSet = mutableSetOf<String>()
    for ((key, value) in sequenceListMap){
        while (index <= s.length - k){
             if (key == s.substring(index,index+k)){
                 sequenceListMap[key] = sequenceListMap[key]!! + 1
                 if(sequenceListMap[key]!!>0){
                     outputSet.add(key)
                 }
             }
            index++
        }
        index = 0
    }
    println("Output List: $outputSet")

    return ""
}
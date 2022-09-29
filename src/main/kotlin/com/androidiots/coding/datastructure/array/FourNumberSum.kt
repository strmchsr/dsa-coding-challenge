package com.androidiots.coding.datastructure.array


/**
 * hard
 * Brute force Time Complexity : n^4
 * Optimal Time Complexity : n^2
 */
fun fourNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    // Write your code here.
    val allPairSum = mutableMapOf<Int,MutableList<MutableList<Int>>>()
    val quadruplets = mutableListOf<MutableList<Int>>()
    //1st iteration from index to right
    for (i in 1 until array.size-1){
        for(j in i+1 until array.size){
            val currentSum = array[i]+array[j]
            val difference = targetSum - currentSum
            if(allPairSum.containsKey(difference)){
                for (pair in allPairSum[difference]!!){
                    val p = pair.toMutableList();
                    p.add(array[i])
                    p.add(array[j])
                    quadruplets.add(p)
                }
            }
        }

        //2nd iteration from 0 to index, update the map only for this iteration(left part of the index)

        for (k in 0 until i){
            val sum = array[i]+array[k]
            if(!allPairSum.containsKey(sum)){
                allPairSum[sum] = mutableListOf(mutableListOf(array[i],array[k]))
            } else {
                allPairSum[sum]!!.add(mutableListOf(array[i],array[k]))
            }
        }
    }

    return quadruplets
}
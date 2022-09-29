package com.androidiots.coding.datastructure.array

import kotlin.math.abs

/**
 * we have series of block which contains the buildings (all or some) (gym, school,store )
 * which block should we buy for the optimal distance (have to travel minimum distance)
 *  Sc  G  G    Sc   Sc    *** array of block containing the buildings
 *         Sc        St
 */

// this is less optimal with time complexity : O(b^2 * r + b)
fun apartmentHunting(blocks: List<Map<String, Boolean>>, reqs: List<String>): Int {
    // Write your code here.
    var maxDistances = IntArray(blocks.size){ Int.MIN_VALUE}
    for ((i, block) in blocks.withIndex()){
        for ((reqIdx, req) in reqs.withIndex()){
            var minDistance = Int.MAX_VALUE
            for ((j, block) in blocks.withIndex()){
               if(block[req] == true){
                   var currentDistance = distanceBetween(i, j)
                   minDistance = minOf(minDistance , currentDistance)
               }
            }
            maxDistances[i] = maxOf( maxDistances[i],minDistance)
        }
    }
    var optimalIdx = -1
    var min = Int.MAX_VALUE
    for((idx, value) in maxDistances.withIndex()){
        if(value < min){
            min = value
            optimalIdx = idx
        }
    }
    return optimalIdx
}

fun distanceBetween(source: Int, dest : Int):Int {
    return abs(dest - source)
}

fun apartmentHuntingOptimumTime(blocks: List<Map<String, Boolean>>, reqs: List<String>): Int {
    // Write your code here.
    var maxDistances = IntArray(blocks.size){ Int.MIN_VALUE}
    for ((i, block) in blocks.withIndex()){
        for ((reqIdx, req) in reqs.withIndex()){
            var minDistance = Int.MAX_VALUE
            for ((j, block) in blocks.withIndex()){
                if(block[req] == true){
                    var currentDistance = distanceBetween(i, j)
                    minDistance = minOf(minDistance , currentDistance)
                }
            }
            maxDistances[i] = maxOf( maxDistances[i],minDistance)
        }
    }
    var optimalIdx = -1
    var min = Int.MAX_VALUE
    for((idx, value) in maxDistances.withIndex()){
        if(value < min){
            min = value
            optimalIdx = idx
        }
    }
    return optimalIdx
}

fun main() {
    val blocks = listOf<Map<String, Boolean>>(
        mapOf("gym" to false, "school" to true, "store" to false),
        mapOf("gym" to true, "school" to false, "store" to false),
        mapOf("gym" to true, "school" to true, "store" to false),
        mapOf("gym" to false, "school" to true, "store" to false),
        mapOf("gym" to false, "school" to true, "store" to true)
    )
    val reqs = listOf("gym", "school", "store")
    println(apartmentHunting(blocks, reqs))
}



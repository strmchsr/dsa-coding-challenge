package com.androidiots.coding.netflix

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class GroupSimilarTitle {

  fun groupTitles(inputStringArr : Array<String>): List<List<String>>{
    val freqCount = IntArray(26)
    val freqMap : MutableMap<String,MutableList<String>> = HashMap()
    for(str in inputStringArr){
      Arrays.fill(freqCount, 0)
      for(c in str.toCharArray()){
        val index = c - 'a'
        freqCount[index]++
      }
      val delimStr= StringBuilder()
      for (i in 0..25){
        delimStr.append("#")
        delimStr.append(freqCount[i])
      }
      val key = delimStr.toString()
      if(freqMap.containsKey(key)){
        freqMap[key]!!.add(str)
      } else {
        freqMap[key] = ArrayList()
        freqMap[key]!!.add(str)
      }
    }

    return ArrayList<List<String>>(freqMap.values)
  }

}
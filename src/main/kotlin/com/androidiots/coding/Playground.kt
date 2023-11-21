package com.androidiots.coding

import java.lang.StringBuilder

fun recursiveTest(str : String?, sb :StringBuilder, value:Int):StringBuilder{
    println("recursiveTest called for $str, current sb is : ${sb.toString()}")
    if(value == 0){
        return sb
    }
    var currValue = value -1
    sb.append(value)
    recursiveTest(str = str, sb = sb, value = currValue)

    return sb
}

fun main() {
    //println("Max Profit: ${maxProfitFromStocks(intArrayOf(1,2,4,2,5,7,2,4,9,0,9))}")
    //println(minWindow("fgrqsqsnodwmxzkzxwqegkndaa","kzed"))

    val list = arrayListOf("dsds","dsds","Dsds")
    val update = list.map {
        12
    }
    println(update)
}


/**
 * Stock Prices [7,1,5,3,6,4]
 */

fun maxProfitFromStocks(arr: IntArray) : Int{
    var currentBuyingPrice = arr[0]
    var currentSellingPrice = arr[1]
    var maxProfit = Int.MIN_VALUE
    for (index in 1 until arr.size){
        if(maxProfit < (arr[index] - currentBuyingPrice)) {
            currentSellingPrice = arr[index]
            maxProfit = arr[index] - currentBuyingPrice
        }
       if(currentBuyingPrice > arr[index]){
           currentBuyingPrice = arr[index]
       }
    }
    println("$currentSellingPrice   $currentBuyingPrice")

    return maxProfit
}

/**
 * str1 : "abcdebdde"
 * str2 : "bde"
 */
fun minWindow(s: String, pattern:String):String {
    val strArr = s.toCharArray()
    val patterArr = pattern.toCharArray()
    var indexStr = 0
    var indexPattern = 0
    var length = Int.MAX_VALUE
    var minSequence = ""
    while (indexStr < s.length){
        if (strArr[indexStr] == patterArr[indexPattern]){
            indexPattern++
            if (indexPattern == pattern.length){
                  var start = indexStr
                  var end = indexStr+1
                  indexPattern-=1
                while (indexPattern>=0){
                    if(strArr[start] == patterArr[indexPattern]){
                        indexPattern--
                    }
                    start -= 1
                }
                start +=1
                if((end - start)<length){
                    length = end - start
                    minSequence = s.substring(start,end)
                }
                indexStr = start
                indexPattern = 0
            }
        }
        indexStr++

    }
    return minSequence
}
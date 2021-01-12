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
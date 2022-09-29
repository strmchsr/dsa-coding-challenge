package com.androidiots.coding

fun nonConstructibleChange(coins: MutableList<Int>): Int {
    coins.sort()
    var currentChange = 0
    for (number in coins){
        if(currentChange+1>=number){
            currentChange+=number
        } else {
            return currentChange+1
        }
    }
    return -1
}

fun main() {
    print(nonConstructibleChange(mutableListOf(5,7,1,1,2,3,22)))
}

//this one took me a while too, but this was how I made sense of it:
//
//Assume you've proven you can make 1-8 cents.
//
//You go to the next iteration and want to know if you can make 9 cents. So you iterate to the next new coin in the sorted list.
//
//if newCoin < 9:
//
//You know for a fact that you can make 9 cents.
//Example if the new coin is 5: Use that new coin and subtract it from the total you're trying to make. 9 - 5 = 4. Then however way you made 4 previously just do that again. (You've already proven you can make 1-8 cents)
//if newCoin == 9:
//
//You know for a fact that you can make 9 cents.
//Just use the 9 cent coin
//if newCoin > 9:
//
//You know for a fact that you CANNOT make 9 cents
//This is because you can't use the new coin. For example, a 10 cent coin is useless to you when you're trying to make 9 cents since it's too big (can't make 9)
//You're also screwed if you don't use the new coin because if you add up all the coins you've seen so far, you've only been able to make 8 (can't make 9)
//And that's where the change + 1 comes from. (your variable change = 8)
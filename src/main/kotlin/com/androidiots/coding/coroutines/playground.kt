package com.androidiots.coding.coroutines

import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

val seq = sequence {
    yield(1)
    yield(2)
    yield(3)
}

suspend fun main() {

//    println("Before")
//    suspendCoroutine<Unit> { continuation ->
//        println("Before too")
//        continuation.resume(Unit)
//    }
//    doSomething { s, i ->
//        "$color $s $i"
//    }
//    println("After")

    println("Before")

    suspendAndSetContinuation()
   // continuation?.resume(Unit)

    println("After")

}

fun doSomething(block: CarBuilder.(String,Int) -> Unit) {
    val builder = CarBuilder()
    builder.block("Shashank", 42)
}


var continuation: Continuation<Unit>? = null

suspend fun suspendAndSetContinuation() {
    suspendCoroutine<Unit> { cont ->
        cont.resume(Unit)
        continuation = cont
    }
}



data class Car(val color:String, val engine:String, val transmission: String)




class CarBuilder {
    var color: String = ""
    var engine: String = ""
    var transmission: String = ""
}

fun car(block: CarBuilder.() -> Unit): Car {
    val builder = CarBuilder()
    builder.block() // Apply the configuration block
    return Car(builder.color, builder.engine, builder.transmission)
}


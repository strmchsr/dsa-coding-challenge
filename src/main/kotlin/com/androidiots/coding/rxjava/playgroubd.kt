package com.androidiots.coding.rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import java.lang.Exception

fun main() {
    Observable.just(1,2,3).subscribe {
        println(it)
    }
    val observable = Observable.range(0, 10).flatMap { i: Int ->
        if (i == 3) Observable.error(
            Exception("An error occurred")
        ) else Observable.just(i)
    }
    observable.subscribe(
        { i: Int? -> }
    ) { throwable: Throwable -> println("onError(): " + throwable.message) }
}
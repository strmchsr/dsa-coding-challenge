package com.androidiots.coding.datastructure.linkedlist

// This is an input class. Do not edit.
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun middleNode(linkedList: LinkedList): LinkedList {
    // Write your code here.
    var slowNode: LinkedList? = linkedList
    var fastNode: LinkedList? = linkedList
    while (fastNode?.next != null) {
        slowNode = slowNode?.next
        fastNode = fastNode?.next?.next

    }
    return slowNode!!
}



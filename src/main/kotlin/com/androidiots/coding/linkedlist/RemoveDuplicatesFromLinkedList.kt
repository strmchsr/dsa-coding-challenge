package com.androidiots.coding.linkedlist

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
    override fun toString(): String {
        return "$value ->"
    }
}

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
    // Write your code here.
    var currentNode:LinkedList? = linkedList
    while (currentNode != null) {
        var nextDistinctNode = currentNode.next
        while (nextDistinctNode != null && currentNode.value == nextDistinctNode.value) {
            nextDistinctNode = nextDistinctNode.next
        }
        currentNode.next = nextDistinctNode
        currentNode = nextDistinctNode
    }
    return linkedList
}

fun addMany(linkedList: LinkedList, values: List<Int>): LinkedList {
    var current = linkedList
    while (current.next != null) {
        current = current.next!!
    }
    for (value in values) {
        current.next = LinkedList(value)
        current = current.next!!
    }
    return linkedList
}

fun main() {
    val input = addMany(LinkedList(1), listOf(1, 3, 4, 4, 4, 5, 6, 6))
    val output = removeDuplicatesFromLinkedList(input)
    println(output)
}

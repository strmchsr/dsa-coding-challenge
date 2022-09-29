package com.androidiots.coding.datastructure.linkedlist

fun reverse(list : SinglyLinkedList<String>){
    var prevNode : SinglyLinkedList<String>.Node? = null
    var currentNode : SinglyLinkedList<String>.Node? = list.headNode
    var nextNode : SinglyLinkedList<String>.Node?  = null

    while (currentNode != null){
        nextNode = currentNode.nextNode
        currentNode.nextNode = prevNode
        prevNode = currentNode
        currentNode = nextNode
    }
    list.headNode = prevNode
}

fun main() {
    var list = SinglyLinkedList<String>()
    list.insertAtEnd("A")
    list.insertAtEnd("B")
    list.insertAtEnd("C")
    list.print()
    reverse(list)
    list.print()
}
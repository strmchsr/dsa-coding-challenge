package com.androidiots.coding.datastructure.linkedlist

class DoublyLinkedList<T> {
    inner class Node(var data : T, var nextNode : Node?, var prevNode : Node?){

    }

    var headNode : Node? = null
    var tailNode : Node? = null
    var size: Int = 0

    fun isEmpty():Boolean{
        return headNode == null && tailNode== null
    }

    fun insertAtHead(data: T) {
        val newNode = Node(data = data, nextNode = headNode, prevNode = null)
        if (headNode != null) headNode?.prevNode = newNode else tailNode = newNode
        headNode = newNode
        size++
    }

    fun insertAtEnd(data: T) {
        if (isEmpty()) {
            insertAtHead(data)
            return
        }
        val newNode = Node(data = data, nextNode = null, prevNode = tailNode)
        newNode.data = data
        newNode.nextNode = null
        newNode.prevNode = tailNode
        tailNode?.nextNode = newNode
        tailNode = newNode
        size++
    }

    fun printList() {
        if (isEmpty()) {
            println("List is Empty!")
            return
        }
        var temp = headNode!!
        print("List : null <- ")
        while (temp.nextNode != null) {
            print(temp.data.toString().toString() + " <-> ")
            temp = temp.nextNode!!
        }
        println(temp.data.toString().toString() + " -> null")
    }

    fun printListReverse() {
        if (isEmpty()) {
            println("List is Empty!")
        }
        var temp = tailNode!!
        print("List : null <- ")
        while (temp.prevNode != null) {
            print(temp.data.toString().toString() + " <-> ")
            temp = temp?.prevNode!!
        }
        println(temp.data.toString().toString() + " -> null")
    }

    fun deleteAtHead() {
        if (isEmpty()) return
        headNode = headNode?.nextNode
        if (headNode == null) tailNode = null else headNode?.prevNode = null
        size--
    }

    fun deleteAtTail() {
        if (isEmpty()) return
        tailNode = tailNode?.prevNode
        if (tailNode == null) headNode = null else tailNode?.nextNode = null
        size--
    }
}
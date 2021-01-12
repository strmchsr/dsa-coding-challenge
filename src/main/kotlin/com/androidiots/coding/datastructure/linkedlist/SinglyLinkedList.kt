package com.androidiots.coding.datastructure.linkedlist

import java.lang.StringBuilder

class SinglyLinkedList<T>     //constructor
{
    //Node inner class for SLL
    inner class Node {
        var data //Data to store (could be int, string, Object etc)
                : T? = null
        var nextNode //Pointer to next node in list
                : Node? = null
    }

    var headNode //head node of the linked list
            : Node? = null
    var size //size of the list
            = 0

    fun isEmpty(): Boolean {
        return headNode == null
    }

    fun insertAtEnd(data: T) {
        if (isEmpty()) {
            headNode = Node()
            headNode!!.data = data
            headNode!!.nextNode = null
        } else {
            var tempNode = headNode
            while (tempNode?.nextNode != null) {
                tempNode = tempNode?.nextNode
            }
            var newNode = Node()
            newNode.data = data
            newNode.nextNode = null
            tempNode?.nextNode = newNode
        }
    }

    fun print(){
        var tempNode = headNode
        var sb = StringBuilder()
        while (tempNode?.nextNode != null ){
            sb.append("${tempNode?.data} ->")
            tempNode = tempNode.nextNode
        }
        sb.append("${tempNode?.data} ")
        println("Linked List : $sb")
    }

    fun reverse(){
        if(isEmpty()){
            return
        }
        var currentNode = headNode
        var prevNode : Node ? = null
        var next : Node ? = null
        while (currentNode != null){
            next = currentNode.nextNode
            currentNode.nextNode = prevNode
            prevNode = currentNode
            currentNode = next
        }
        headNode = prevNode

    }
}
package com.androidiots.coding.datastructure.linkedlist

import com.androidiots.coding.IdName

fun detectLoop(list : SinglyLinkedList<Int>):Boolean{
    var currentNode = list.headNode
    val set = mutableSetOf<Int>()
    while (currentNode != null){
        if(!set.add(currentNode.data!!)){
            return true
        }
        currentNode = currentNode.nextNode
    }

    return false
}

fun detectLoopFloydAlgorithm(list : SinglyLinkedList<IdName>): SinglyLinkedList<IdName>.Node? {
    var slow = list.headNode
    var fast = list.headNode
    while (fast?.nextNode != null){
        slow = slow?.nextNode
        fast = fast?.nextNode?.nextNode
        if(fast == slow){
            break
        }
    }
    if(fast?.nextNode == null){
        return null
    }

    slow = list.headNode
    while (fast != slow){
        fast = fast?.nextNode
        slow = slow?.nextNode
    }
    return fast
}
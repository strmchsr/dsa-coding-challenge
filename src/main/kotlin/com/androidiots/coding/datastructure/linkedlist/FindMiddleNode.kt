package com.androidiots.coding.datastructure.linkedlist

fun findMiddleNode(list: SinglyLinkedList<Int>): SinglyLinkedList<Int>.Node?{

    var slow = list.headNode
    var fast = list.headNode
    while (fast?.nextNode != null){

        fast = fast?.nextNode?.nextNode
        if(fast != null){
            slow = slow?.nextNode
        }
    }
    return slow

}

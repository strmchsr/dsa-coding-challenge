package com.androidiots.coding.datastructure.linkedlist

fun findIntersection(list1: SinglyLinkedList<Int>, list2: SinglyLinkedList<Int>): SinglyLinkedList<Int>.Node? {
    var result1 = findTailAndSize(list1)
    var result2 = findTailAndSize(list2)

    if(result1.node != result2.node){
        return null
    }

    var shorterList = if(result1.size>result2.size) list2 else list1
    var longerList = if(result1.size>result2.size) list1 else list2
    var shorter = shorterList.headNode
    var longer = getKthNode(longerList, Math.abs(result1.size-result2.size))
    while (shorter != longer){
        shorter = shorter?.nextNode
        longer = longer?.nextNode
    }
    return longer
}
data class Result(var node: SinglyLinkedList<Int>.Node?, var size: Int)

private fun findTailAndSize(list : SinglyLinkedList<Int>): Result{
    var size = 1
    var node = list.headNode
    while (node?.nextNode != null){
        size++
        node = node?.nextNode
    }
    return Result(node = node, size = size)
}

private fun getKthNode(list : SinglyLinkedList<Int>, k :Int):SinglyLinkedList<Int>.Node?{
    var n =k
    var currntNode = list.headNode
    while (n>0 && currntNode != null){
        currntNode = currntNode.nextNode
        n--
    }
    return currntNode!!
}
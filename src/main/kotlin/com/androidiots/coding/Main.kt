package com.androidiots.coding

import com.androidiots.coding.datastructure.graph.Graph
import com.androidiots.coding.datastructure.linkedlist.*
import com.androidiots.coding.datastructure.tree.*
import java.lang.StringBuilder

fun main(args: Array<String>) {
//    var bst = BSTInsertionRecursive()
//    bst.insert(29)
//    bst.insert(8)
//    bst.insert(3)
//    bst.insert(9)
//    bst.insert(12)
//    bst.insert(7)
//    bst.insert(5)
//    bst.insert(3)
//    bst.printBST(bst.getRoot())
//
//    bst.getRoot()?.let { println("kth max value : ${findKthMax(root = it, k = 3)}") }
//    bst.getRoot()?.let { println("path to 7:${findAncestorBST(root = it, k = 7)}") }
//    bst.getRoot()?.let { println("path to 5:${findAncestorBST(root = it, k = 5)}") }
//    bst.getRoot()?.let { println("path to 9:${findAncestorBST(root = it, k = 9)}") }
//    bst.getRoot()?.let { println("Height of tree : ${findHeight(root = it)}") }
//    var bstSearchRecursive = BSTSearchRecursive()
//    bstSearchRecursive.search(root = bst.getRoot(), value = 1)
//    println("Min value is :${bst.getRoot()?.let { findMin(it) }}")
//
//    var bstDeletion = BSTDeletion(bst = bst)
//    bstDeletion.delete(root = bst.getRoot(), value = 5)
//    bst.printBST(bst.getRoot())
//
//    var bst1= BSTInsertionRecursive()
//    bst1.insert(6)
//    bst1.insert(4)
//    bst1.insert(9)
//    bst1.insert(2)
//    bst1.insert(5)
//    bst1.insert(8)
//    bst1.insert(12)
//    bst1.insert(10)
//    bst1.insert(14)
//    bst1.printBST(bst1.getRoot())
//    bst.getRoot()?.let { println("Height of tree : ${findHeight(root = it)}") }
//    bst1.getRoot()?.let {  println("fing nodes at distance 3:${findNodesAtKthDistance(root = it, k = 2)}") }


//    //Linked List
//    var list = SinglyLinkedList<IdName>()
//    list.insertAtEnd(data = IdName(id = 1, name = "Shashank"))
//    list.insertAtEnd(data = IdName(id = 2, name = "Ramesh"))
//    list.insertAtEnd(data = IdName(id = 3, name = "Suresh"))
//    list.insertAtEnd(data = IdName(id = 4, name = "John"))
//    list.headNode?.nextNode?.nextNode = list.headNode
//   // list.print()
//   // list.reverse()
//  //  list.print()
//    println("list contains loop?: ${detectLoopFloydAlgorithm(list = list)?.data?.name}")

//    var list1 = SinglyLinkedList<Int>()
//    list1.insertAtEnd(data = 7)
//    list1.insertAtEnd(data = 14)
//    list1.insertAtEnd(data = 10)
//    list1.insertAtEnd(data = 21)
//    list1.print()
//
//    var list2 = SinglyLinkedList<Int>()
//    list2.insertAtEnd(data = 23)
//    list2.headNode?.nextNode = list1.headNode?.nextNode?.nextNode
//    list2.print()
//    println("list contains loop?: ${detectLoop(list = list1)}")
//    println("Middle Node: ${findMiddleNode(list = list1)?.data}")
//
//    println("Intersection: ${findIntersection(list1, list2)?.data}")

    //Graph

    var graph = Graph(4)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 3)

    graph.printGraph()

}

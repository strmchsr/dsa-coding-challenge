package com.androidiots.coding.datastructure.graph

import com.androidiots.coding.datastructure.linkedlist.DoublyLinkedList




class Graph(var vertices : Int) {
     var adjacencyList : Array<DoublyLinkedList<Int>> = Array(vertices) {
         DoublyLinkedList()
     }

    fun addEdge(source : Int , destination : Int){
        if(source < vertices && destination < vertices){
            adjacencyList[source].insertAtEnd(data = destination)
            //for undirected graph
            adjacencyList[destination].insertAtEnd(data = source)
        }
    }
    fun printGraph() {
        println(">>Adjacency List of Directed Graph<<")
        for (i in 0 until vertices) {
            if (adjacencyList[i] != null) {
                print("|$i| => ")
                var temp: DoublyLinkedList<Int>.Node? = adjacencyList[i].headNode
                while (temp != null) {
                    print("[" + temp.data + "] -> ")
                    temp = temp?.nextNode
                }
                println("null")
            } else {
                println("|$i| => null")
            }
        }
    }

}
package com.androidiots.coding.datastructure.graph
import com.androidiots.coding.linkedlist.DoublyLinkedList
import com.androidiots.coding.linkedlist.Node

class Graph constructor(vertices : Int) {
    var vertices = 0
    var adjacencyList : MutableList<DoublyLinkedList<Int>> = mutableListOf()
    init {
        this.vertices = vertices
        for (vert in 0..vertices){
            adjacencyList.add(DoublyLinkedList())
        }
    }

    fun addEdge(source : Int, dest: Int){
        if(source < vertices && dest<vertices){
            this.adjacencyList[source].insertAtEnd(dest)
        }
    }

    fun printGraph(){
        println(">>Adjacency List of Directed Graph<<")
        for (i in 0 until vertices) {
            if (adjacencyList[i] != null) {
                print("|$i| => ")
                var temp: Node<Int>? = adjacencyList[i].headNode
                while (temp != null) {
                    print("[" + temp.data.toString() + "] -> ")
                    temp = temp.nextNode
                }
                println("null")
            } else {
                println("|$i| => null")
            }
        }
    }
}
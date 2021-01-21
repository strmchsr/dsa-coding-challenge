package com.androidiots.coding.datastructure.graph

import java.util.*

fun main(){
    val g1 = Graph(4)
    g1.addEdge(0, 1)
    g1.addEdge(1, 2)
    g1.addEdge(1, 3)
    g1.addEdge(3, 0)
    g1.printGraph()
    println("detectCycle : ${detectCycle(g1)}")

    val g2 = Graph(3)
    g2.addEdge(0, 1)
    g2.addEdge(1, 2)
    g2.printGraph()
    println("detectCycle : ${detectCycle(g2)}")
}

fun detectCycle(graph: Graph):Boolean{
    var visited = BooleanArray(graph.vertices)
    for (value in 0 until graph.vertices){
        return isCycle(graph, visited,value)
    }

    return false
}

private fun isCycle(graph: Graph, visited : BooleanArray, source : Int): Boolean{
    var stack = Stack<Int>()
    stack.push(source)
    visited[source] = true
    while (stack.isNotEmpty()){
        var currentNode = stack.pop()
        var temp = graph.adjacencyList[currentNode].headNode
        while (temp != null){
            if(temp.data == source){
                return true
            }
            if(!visited[temp.data]){
                stack.push(temp.data)
                visited[source] = true
            }
            temp = temp.nextNode
        }
    }
    return false
}